package com.example.lab2cats.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val instance = retrofit.create(ApiService::class.java)

}