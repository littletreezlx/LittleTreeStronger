package com.example.littletreestronger.di

import SSLSocketClient
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.example.littletreestronger.common.base.BaseApplication
import com.example.littletreestronger.data.AppDatabase
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val HTTP_DI_MODULE = "HttpDiModule"
const val HTTP_DI_MODULE_LOG_TAG = "HttpDiModuleLogTag"

const val TIME_OUT_SECONDS = 10
const val BASE_URL = "https://www.baidu.com/"

val httpDiModule = Kodein.Module(HTTP_DI_MODULE){

    //gson
    bind<Gson>() with singleton { Gson() }

    //okhttp
    bind<OkHttpClient.Builder>() with singleton { OkHttpClient.Builder() }

    //log Interceptor
    bind<Interceptor>(HTTP_DI_MODULE_LOG_TAG) with singleton {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    bind<OkHttpClient>() with singleton {
        instance<OkHttpClient.Builder>()
            .sslSocketFactory(SSLSocketClient().getSSLSocketFactory())//配置
            .hostnameVerifier(SSLSocketClient().getHostnameVerifier())//配
            .connectTimeout(TIME_OUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .readTimeout(TIME_OUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .addInterceptor(instance(HTTP_DI_MODULE_LOG_TAG))
            .build()
    }


    //retrofit
    bind<Retrofit.Builder>() with provider { Retrofit.Builder() }



//    bind<Retrofit>() with singleton {
//        instance<Retrofit.Builder>()
//            .baseUrl(BASE_URL)
//            .client(instance())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }


//    bind<Retrofit>(tag = "DnD10") with multiton {url : String ->
//        instance<Retrofit.Builder>()
//            .baseUrl(url)
//            .client(instance())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }

    bind<Retrofit>() with multiton {url : String ->
        instance<Retrofit.Builder>()
            .baseUrl(url)
            .client(instance())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    bind<AppDatabase>() with singleton {
        AppDatabase.getInstance(BaseApplication.instance())
    }



}