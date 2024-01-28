package com.example.mygemini

import android.annotation.SuppressLint
import android.app.DownloadManager.Query
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mygemini.ui.theme.MyGeminiTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.create

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val mainViewModel : MainViewModel by viewModels()

            MyGeminiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Gemini(mainViewModel)
                    
                }
            }
        }
    }
}
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Link(mainViewModel: MainViewModel) {

    val key = "AIzaSyAoDZj7Ujnw2-m-_GVYwItrP_S8f23lcfI"

    val link = RetrofitObject.getLink().create(PostAPI::class.java)
    GlobalScope.launch {
        val result = link.getAnswer( key,mainViewModel.postBody.value )
        if(result!=null){
            Log.e("RESULT", result.body().toString())
        }
        else{
            Log.e("RESULT","null")
        }

    }


}
