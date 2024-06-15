package com.example.tutorial.ui.theme.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tutorial.R
import com.example.tutorial.ui.theme.QuoteX


@Composable
fun HomeScreen(modifier:Modifier, data: Array<QuoteX>, onClick: (quote: QuoteX) -> Unit) {
    
    LazyVerticalGrid(
        modifier = modifier,columns = GridCells.Fixed(2)) {
        items(data) { // Assuming you want to display 10 cards
         Quotes(qoute = it, onClick = onClick)

        }
    }
}
@Composable
fun Quotes(qoute: QuoteX, onClick: (quote:QuoteX) -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onClick(qoute) }  // Corrected onClick syntax
            .padding(8.dp)
            .fillMaxWidth(),  // Ensure each card occupies full width of its container
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row {
                Icon(painter = painterResource(id =  R.drawable.baseline_format_quote_24),
                    contentDescription = "null",
                    modifier = Modifier.padding(3.dp).rotate(180F))
            }
            Text(text = qoute.quote)
            HorizontalDivider()
            Text(
                text = qoute.author,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
