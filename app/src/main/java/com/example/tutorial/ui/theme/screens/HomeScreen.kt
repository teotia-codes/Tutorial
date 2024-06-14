package com.example.tutorial.ui.theme.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tutorial.ui.theme.QuoteX


@Composable
fun HomeScreen(modifier:Modifier = Modifier, data: Array<QuoteX>, onClick: () -> Unit) {
    
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(data) { // Assuming you want to display 10 cards
         Quotes(qoute = it, onClick = {})
        }
    }
}

@Composable
fun Quotes(qoute: QuoteX, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onClick }
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = qoute.quote)
            HorizontalDivider()
            Text(text = qoute.author, fontWeight = FontWeight.Bold)
            // Add an Image composable here if you want todisplay an image
        }
    }

}