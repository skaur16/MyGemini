package com.example.mygemini

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Query

interface PostAPI {

    @POST("gemini-pro:generateContent")
    suspend fun getAnswer(
        @Query("key") key : String ,
        @Body postBody: PostBody) : Response<ReceiveData>

}