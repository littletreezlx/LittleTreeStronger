package com.example.littletreestronger.ui.community

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.littletreestronger.R
import com.example.littletreestronger.common.base.BaseFragment
import com.example.littletreestronger.network.RetrofitRequest
import com.example.littletreestronger.viewmodel.TestViewModel
import com.google.gson.Gson
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.community_fragment.*
import org.kodein.di.generic.instance
import retrofit2.Retrofit
import timber.log.Timber


class CommunityFragment : BaseFragment(){


//    private val testVM: TestViewModel by viewModels<> {  }

    private val testVM by viewModels<TestViewModel>(
        {activity as ViewModelStoreOwner },
        {TestViewModelFactory("s")})

//    private val testVM: TestViewModel by viewModels()

    class TestViewModelFactory(
        private val str: String
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>) = TestViewModel(str) as T
    }



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

//        val s=iv.imageResource
        btn_add_Image.setOnClickListener {
//            Glide.with(this)
//                .load("104.199.227.200:22/images/random")
//                .placeholder(R.drawable.loading)
//                .error(R.drawable.error)
//                .centerCrop()
//                .into(iv)
//            launch(Dispatchers.IO) {
//                val image = getImage()
//                withContext(Dispatchers.Main){
//                    showImage(image)
//                }
//            }
        }

    }

    fun getImage(): Bitmap{
        val imagesRequest = retrofit.create(RetrofitRequest::class.java)
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
