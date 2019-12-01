package com.example.littletreestronger.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;


public interface RetrofitRequest {





    @POST("images/random")
    Call<ResponseBody> downloadRandomImage();


    @POST("hello")
    Call<ResponseBody> getHelloWorld();


}

