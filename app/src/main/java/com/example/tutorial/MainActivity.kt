package com.example.tutorial


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.material3.ExperimentalMaterial3Api


import com.example.tutorial.api.TweetsApi
import com.example.tutorial.screens.CategoryScreen
import com.example.tutorial.screens.DetailCatScreen

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    @SuppressLint("CoroutineCreationDuringComposition")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
/*CoroutineScope(Dispatchers.IO).launch {
            delay(10000)
            DataManager.load(applicationContext)
        }*/
        setContent {
  DetailCatScreen()
               /* Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = { TopAppBar(title = { Text(text = "Quotes App", textAlign = TextAlign.Center)
                                                 },
                        ) }) { innerPadding ->
                  App(modifier = Modifier.padding(innerPadding))
*/

            }
        }
    }
/*
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
 /* Keyboard()
    TextField(value = "", onValueChange = {})
*/
    Loader(modifier = modifier)
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

@Composable
fun Loader(modifier: Modifier ) {
    val degree = produceState(initialValue = 0) {
        while (true){
            delay(16)
            value = (value + 10) % 360
        }
    }

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize()) {
            Image(imageVector = Icons.Default.Refresh,
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .rotate(degree.value.toFloat()))
            Text(text = "Loading")
        }
    }
enum class Pages{
    LISTING,
    DETAIL
}*/