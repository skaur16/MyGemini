package com.example.mygemini

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Gemini(mainViewModel: MainViewModel) {

    Column() {
        TopAppBar(title = {
            Text(text = "My Gemini")
            TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Blue)
        })

        Row() {
            TextField(value = mainViewModel.question.value,
                onValueChange = {
                    mainViewModel.question.value = it
                    mainViewModel.text.value = mainViewModel.question.value
                })

            Button(onClick = {
                mainViewModel.link()
            })

            {
                Text(text = "Search")
            }
        }

        if (mainViewModel.link.value) {
            Link(mainViewModel)

            Row() {
                Box() {
                    Text(text = "hello")
                }
            }
        }
    }

}
