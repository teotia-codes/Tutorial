package com.example.tutorial.api

import com.example.tutorial.TweetData
import com.example.tutorial.ui.theme.Tweet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsApi {
   @GET("/v3/b/666f1958ad19ca34f879d97c?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path")  category:String):Response<List<TweetData>>

    @GET("/v3/b/666f1958ad19ca34f879d97c?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories(): Response<List<String>>

}