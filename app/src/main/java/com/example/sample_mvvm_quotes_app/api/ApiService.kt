package com.example.sample_mvvm_quotes_app.api

import com.example.sample_mvvm_quotes_app.model.QuotesResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("/")
    fun getQuotes() : Observable<QuotesResponse>
}