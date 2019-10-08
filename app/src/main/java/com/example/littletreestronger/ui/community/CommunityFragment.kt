package com.example.littletreestronger.ui.community

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.renderscript.Script
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.work.impl.Schedulers
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.littletreestronger.common.base.BaseFragment
import com.example.littletreestronger.R
import com.example.littletreestronger.network.BingRetrofitRequest
import com.example.littletreestronger.network.ImagesRetrofitRequest
import com.google.gson.Gson
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.community_fragment.*
import kotlinx.coroutines.*
import org.kodein.di.Factory
import org.kodein.di.bindings.Multiton
import org.kodein.di.generic.factory
import org.kodein.di.generic.instance
import retrofit2.Retrofit
import timber.log.Timber
import kotlin.coroutines.CoroutineContext


class CommunityFragment : BaseFragment(){


    private val retrofit: Retrofit by instance(arg = "https://104.199.227.200:8443/")

    private val gson: Gson by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.community_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_add_Image.setOnClickListener {
//            Glide.with(this)
//                .load("104.199.227.200:22/images/random")
//                .placeholder(R.drawable.loading)
//                .error(R.drawable.error)
//                .centerCrop()
//                .into(iv)
            launch(Dispatchers.IO) {
                val image = getImage()
                withContext(Dispatchers.Main){
                    showImage(image)
                }
            }

        }
    }

    fun getImage(): Bitmap{
        val imagesRequest = retrofit.create(ImagesRetrofitRequest::class.java)
        val response =  imagesRequest.downloadRandomImage().execute()
        Timber.d(response.body()?.contentLength().toString() )
        val image = BitmapFactory.decodeStream(response.body()?.byteStream())
        return image
    }

    fun showImage(bitmap: Bitmap){
        Glide.with(this)
            .load(bitmap)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 3)))
            .into(iv)
    }

}
