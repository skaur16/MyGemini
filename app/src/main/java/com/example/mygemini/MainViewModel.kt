package com.example.mygemini

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var postBody = mutableStateOf(PostBody())
    var question = mutableStateOf("")
    var text = mutableStateOf("")
    var partx = mutableStateOf(PartX())
    var link = mutableStateOf(false)


}