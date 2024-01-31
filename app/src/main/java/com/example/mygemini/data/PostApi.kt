package com.example.mygemini.data

import com.example.mygemini.model.PostBody
import com.example.mygemini.model.ReceiveData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface PostAPI {

    @POST(".")
    suspend fun getAnswer(
        @Query("key") key : String,
        @Body postBody: PostBody
    ) : Response<ReceiveData>

}