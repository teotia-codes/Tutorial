package com.example.tutorial.ui.theme

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.google.gson.Gson

object DataManager  {
    var isDataLoaded by mutableStateOf(false)
    var data = emptyArray<QuoteX>()
    fun load(context: Context){
     val inputStream =  context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<QuoteX>::class.java)
        isDataLoaded = true
    }
}