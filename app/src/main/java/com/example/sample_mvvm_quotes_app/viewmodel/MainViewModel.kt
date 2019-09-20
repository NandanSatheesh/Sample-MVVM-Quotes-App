package com.example.sample_mvvm_quotes_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sample_mvvm_quotes_app.model.QuotesResponse
import com.example.sample_mvvm_quotes_app.retrofit.RetrofitInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {

    val loadingView : MutableLiveData<Int> = MutableLiveData()

    val quotesLiveData: MutableLiveData<QuotesResponse> = MutableLiveData()

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getDataFromApi() {

        val request = RetrofitInstance.request

        loadingView.value = 0

        compositeDisposable.add(
            request.getQuotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    this::handleApiResponse
                )
        )
    }

    fun handleApiResponse(response: QuotesResponse) {
        loadingView.value = 8
        quotesLiveData.value = response
    }

}