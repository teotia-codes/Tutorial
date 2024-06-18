package com.example.tutorial


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


import com.example.tutorial.screens.CategoryScreen
import com.example.tutorial.screens.DetailCatScreen
import com.example.tutorial.viewmodel.CatViewModel
import com.example.tutorial.viewmodel.DetailViewModel

import dagger.hilt.android.AndroidEntryPoint

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
            
            Scaffold(
  topBar = {
      TopAppBar(title = { Text(text = "Tweetify") },
          )
  }
            ) {
                Box(modifier = Modifier.padding(it)){
                    App()
                }
            }
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


@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "category"
    ) {
        composable(route = "category") {
            val viewModel: CatViewModel = hiltViewModel()
            CategoryScreen(viewModel = viewModel) {
                navController.navigate("detailscreen/${it}")
            }
        }
        composable(route = "detailscreen/{cat}", arguments = listOf(navArgument("cat") {
            type = NavType.StringType
        })) {
            val viewModel: DetailViewModel = hiltViewModel()
            DetailCatScreen(viewModel = viewModel)
        }
    }
}