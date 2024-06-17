package com.example.tutorial.repository

import com.example.tutorial.api.TweetsApi
import com.example.tutorial.ui.theme.Tweet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private  val api: TweetsApi){
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> get() = _categories

    private val _tweets = MutableStateFlow<List<Tweet>>(emptyList())
    val tweet: StateFlow<List<Tweet>> get() = _tweets


    suspend fun getCategories(){
        val response = api.getCategories()
        if(response.isSuccessful && response.body() != null)
        _categories.emit(response.body()!!)
    }

    suspend fun getTweets(category: String){
        val response = api.getTweets(category)
        if(response.isSuccessful && response.body() != null)
            _tweets.emit(response.body()!!)
    }

}