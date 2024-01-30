package com.example.mygemini

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Query

interface PostAPI {



    @POST("./")
   // @Multipart
    suspend fun getAnswer(
        @Query("key") key : String,
        @Body postBody: String) : Response<ReceiveData>

}