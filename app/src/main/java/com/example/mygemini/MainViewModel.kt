package com.example.mygemini

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var postBody = mutableStateOf(PostBody())
    var question = mutableStateOf("")
    var text = mutableStateOf("")
    var partx = mutableStateOf(Part())
    var answer = mutableStateOf(listOf(Part()))


    fun link(){

        val key = "AIzaSyAoDZj7Ujnw2-m-_GVYwItrP_S8f23lcfI"

        val link = RetrofitObject.getLink().create(PostAPI::class.java)
        viewModelScope.launch {
            Log.e("TAG", "Post Body -> ${postBody.value}")
            val result = link.getAnswer( key , postBody.value )
            if(result!=null){
                result.body()?.candidates?.forEach {
                    answer.value = it.content.parts
                }

            }

            else{
                Log.e("RESULT","null")
            }

        }
    }

}