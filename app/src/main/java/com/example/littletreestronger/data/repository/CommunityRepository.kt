/*
 * Copyright - LittleTree (c) 2019.
 */

package com.example.littletreestronger.data.repository

import SSLSocketClient
import com.example.littletreestronger.di.TIME_OUT_SECONDS
import com.example.littletreestronger.network.RetrofitRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class CommunityRepository private constructor() {


    companion object {
        @Volatile private var instance: CommunityRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: CommunityRepository().also { instance = it }
            }
    }


    val okHttp = OkHttpClient.Builder()
        .sslSocketFactory(SSLSocketClient().getSSLSocketFactory())//配置
        .hostnameVerifier(SSLSocketClient().getHostnameVerifier())//配
        .connectTimeout(TIME_OUT_SECONDS.toLong(), TimeUnit.SECONDS)
        .readTimeout(TIME_OUT_SECONDS.toLong(), TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    val retrofit =  Retrofit.Builder()
        .baseUrl("https://104.199.227.200:8443/")
        .client(okHttp)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()




    suspend fun getHelloWorld(): String?{
        var result: String? = null
        withContext(Dispatchers.IO){
            val request = retrofit.create(RetrofitRequest::class.java)
            val response =  request.getHelloWorld().execute()
            result = response.body()!!.string()
        }
        return result
    }




}