package com.example.tutorial.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorial.TweetData
import com.example.tutorial.repository.TweetRepository
import com.example.tutorial.ui.theme.Tweet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle,private val repository: TweetRepository) : ViewModel() {
    val tweets : StateFlow<List<TweetData>>
        get() = repository.tweet
    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("cat")?: "News"
            repository.getTweets(category)
        }
    }


}