package com.example.tutorial.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tutorial.viewmodel.DetailViewModel

@Composable
fun DetailCatScreen(modifier: Modifier = Modifier, viewModel: DetailViewModel) {
    val tweet = viewModel.tweets.collectAsState()
    LazyColumn(
        modifier = modifier.systemBarsPadding()
    ){
        items(tweet.value){
            TweetListItem(tweet = it.text)
        }
    }


}


@Composable
fun TweetListItem(tweet: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(text = tweet, modifier = Modifier.padding(16.dp))

    }
}