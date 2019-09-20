package com.example.sample_mvvm_quotes_app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class QuotesResponse(@SerializedName("quote")
                          @Expose
                          val quote : String)