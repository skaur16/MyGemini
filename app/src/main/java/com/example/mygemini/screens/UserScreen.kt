package com.example.mygemini.screens

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
import com.example.mygemini.ContentX
import com.example.mygemini.PartX
import com.example.mygemini.viewmodel.MainViewModel

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
                })

            Button(onClick = {
                mainViewModel.postBody.value = mainViewModel.postBody.value.copy(
                    contents = listOf(
                        ContentX(
                            listOf(
                                PartX(
                                    text = mainViewModel.question.value
                                )
                            )
                        )
                    )
                )

                mainViewModel.getData()
            }
            )

            {
                Text(text = "Search")
            }
        }

    }

}
