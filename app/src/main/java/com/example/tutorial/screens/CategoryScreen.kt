package com.example.tutorial.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tutorial.R
import com.example.tutorial.viewmodel.CatViewModel

@Composable
fun CategoryScreen(modifier: Modifier = Modifier) {
    val viewModel: CatViewModel = viewModel()
    val categories = viewModel.categories.collectAsState()
  LazyVerticalGrid(
      modifier = modifier.systemBarsPadding(),
      columns = GridCells.Fixed(2),
      contentPadding = PaddingValues(8.dp),
      verticalArrangement = Arrangement.SpaceAround
  ) {
      items(categories.value.distinct()){
          CategoryItem(category = it)
      }

  }
}

@Composable
fun CategoryItem(modifier: Modifier = Modifier, category: String) {
    Box (
        modifier = modifier
            .padding(4.dp)
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .paint(painter = painterResource(id = R.drawable.bg),
                contentScale = ContentScale.Crop)
            .border(1.dp, Color.Gray),
        contentAlignment = Alignment.BottomCenter){
       Text(text = category, fontSize = 22.sp, color = Color.White,
           modifier = Modifier.padding(0.dp, 20.dp),
           fontWeight = FontWeight.Bold)
    }
}