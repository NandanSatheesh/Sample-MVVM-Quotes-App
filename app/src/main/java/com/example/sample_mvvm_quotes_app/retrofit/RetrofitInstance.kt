package com.example.sample_mvvm_quotes_app.retrofit

import com.example.sample_mvvm_quotes_app.api.ApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {

        val request = Retrofit.Builder()
            .baseUrl("https://api.kanye.rest")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(ApiService::class.java)
    }

}

