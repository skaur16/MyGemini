package com.example.mygemini

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {

    val BASEURL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent/"

    fun getLink() : Retrofit {
                return Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
    }
}