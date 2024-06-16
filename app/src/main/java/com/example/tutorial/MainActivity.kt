package com.example.tutorial

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.style.TextAlign
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tutorial.ui.theme.DataManager
import com.example.tutorial.ui.theme.TutorialTheme
import com.example.tutorial.ui.theme.screens.DetailScreen
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
/*CoroutineScope(Dispatchers.IO).launch {
            delay(10000)
            DataManager.load(applicationContext)
        }*/
        setContent {
            App(modifier = Modifier)

               /* Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = { TopAppBar(title = { Text(text = "Quotes App", textAlign = TextAlign.Center)
                                                 },
                        ) }) { innerPadding ->
                  App(modifier = Modifier.padding(innerPadding))
*/

            }
        }
    }

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App(modifier: Modifier ) {
   /* if (DataManager.isDataLoaded){
        if (DataManager.currentPage.value == Pages.LISTING){
            HomeScreen(data = DataManager.data, modifier = modifier) {
               DataManager.switchPages(it)
            }
        }
        else{
           DataManager.currentQuote?.let {
            DetailScreen(modifier = modifier, quote =DataManager.currentQuote!!)}
        }
    }
    else{ 

            CircularProgressIndicator(color = Color.Black)

    }*/
   /* var darkTheme by remember {
            mutableStateOf(false)
    }
    TutorialTheme(darkTheme) {

        Scaffold(modifier = modifier) {
            Column {
                Button(onClick = { darkTheme = darkTheme.not()}) {
                    Text(text = "Change theme")
                }
            }
        }
    }*/
  Keyboard()
    TextField(value = "", onValueChange = {})

}

@Composable
fun Keyboard(modifier: Modifier = Modifier) {
    val view = LocalView.current
    DisposableEffect(key1 = Unit) {
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val insets = ViewCompat.getRootWindowInsets(view)
            val isKeyboardOpen = insets?.isVisible(WindowInsetsCompat.Type.ime())
            Log.d("PRISHU", isKeyboardOpen.toString())
        }
        view.viewTreeObserver.addOnGlobalLayoutListener (listener)
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }
    }
}
@Composable
fun Media(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    DisposableEffect(key1 = Unit) {
        val mediaPlayer = MediaPlayer.create(context, R.raw.legend)
        mediaPlayer.start()
        onDispose {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }
}

enum class Pages{
    LISTING,
    DETAIL
}