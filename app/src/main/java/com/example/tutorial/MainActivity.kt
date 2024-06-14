package com.example.tutorial

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorial.ui.theme.DataManager
import com.example.tutorial.ui.theme.TutorialTheme
import com.example.tutorial.ui.theme.screens.HomeScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
            delay(10000)
            DataManager.load(applicationContext)
        }
        setContent {
            TutorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = { TopAppBar(title = { Text(text = "Quotes App", textAlign = TextAlign.Center)
                                                 },
                        ) }) { innerPadding ->
                  App(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier ) {
    if (DataManager.isDataLoaded){
        HomeScreen(data = DataManager.data, modifier = modifier) {
            
        }
    }
    else{ 

            CircularProgressIndicator(color = Color.Black)

    }

}
