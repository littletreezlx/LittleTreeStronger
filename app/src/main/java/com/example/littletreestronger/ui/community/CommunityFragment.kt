package com.example.littletreestronger.ui.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.littletreestronger.base.BaseFragment
import com.example.littletreestronger.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.community_fragment.*
import org.kodein.di.generic.instance
import retrofit2.Retrofit


class CommunityFragment : BaseFragment() {

    companion object {
        fun newInstance() = CommunityFragment()
    }


    private val retrofit: Retrofit by instance()

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



        Glide.with(this)
            .load("https://cn.bing.com/")
            .centerCrop()
            .placeholder(R.drawable.ic_dashboard_black_24dp)
            .into(iv)



//        val bingRetrofitRequest = retrofit.create(BingRetrofitRequest::class.java)
//        bingRetrofitRequest.background
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .doOnNext {
//                it.body().
//            }


    }


}
