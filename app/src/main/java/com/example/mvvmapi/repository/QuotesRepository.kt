package com.example.mvvmapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmapi.api.QuoteInterface
import com.example.mvvmapi.model.Jokes

class QuotesRepository(private val quoteInterface: QuoteInterface) {

    private val quotesLiveData = MutableLiveData<Jokes>()
    val quotes: LiveData<Jokes>
        get() = quotesLiveData

    suspend fun getQuotes() {
        val result = quoteInterface.getQuote()
        if (result.body() != null){
            quotesLiveData.postValue(result.body())
        }
    }
}