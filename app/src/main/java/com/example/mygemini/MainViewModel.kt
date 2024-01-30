package com.example.mygemini

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var postBody = mutableStateOf("")
    var question = mutableStateOf("")
    var text = mutableStateOf("")
    var partx = mutableStateOf(PartX())
    var link = mutableStateOf(false)


    fun link(){


        val x = """
           {
               "contents": [
                   {
                       "parts": [
                           {
                               "text": "how to make coffee"
                           }
                       ]
                   }
               ]
           }
            """.trimIndent()
        val key = "AIzaSyAoDZj7Ujnw2-m-_GVYwItrP_S8f23lcfI"

        val link = RetrofitObject.getLink().create(PostAPI::class.java)
        viewModelScope.launch {
            Log.e("TAG", "Post Body -> ${postBody.value}")
            val result = link.getAnswer( key,x )
            if(result!=null){
                Log.e("RESULT", result.body().toString())
            }
            else{
                Log.e("RESULT","null")
            }

        }
    }

}