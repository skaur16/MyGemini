package com.example.mygemini.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygemini.data.PostAPI
import com.example.mygemini.model.PostBody
import com.example.mygemini.data.RetrofitObject
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var postBody = mutableStateOf(
        PostBody(
        listOf()
    )
    )
    var question = mutableStateOf("")
    var key = mutableStateOf("AIzaSyAoDZj7Ujnw2-m-_GVYwItrP_S8f23lcfI")

    val linkApi = RetrofitObject.getLink().create(PostAPI::class.java)


    fun getData() {

        viewModelScope.launch {
            Log.e("TAG", "Post Body -> ${postBody.value}")
            val result = linkApi.getAnswer(key.value, postBody.value)
            if (result != null) {
                Log.e("RESULT", result.body().toString())
            } else {
                Log.e("RESULT", "null")
            }

        }
    }

}