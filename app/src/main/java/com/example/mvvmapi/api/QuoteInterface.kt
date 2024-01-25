package com.example.mvvmapi.api

import com.example.mvvmapi.model.Jokes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteInterface {

    @GET("/get_memes")
    suspend fun getQuote() : Response<Jokes>
}