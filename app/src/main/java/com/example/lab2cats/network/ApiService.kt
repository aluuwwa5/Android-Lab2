package com.example.lab2cats.network

import com.example.lab2cats.Cat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("X-Api-Key: VkbWFtl1XgCnv+4bFO/asQ==ewLdx9kBvnqvZz0C")
    @GET("v1/cats")
    fun fetchCatsList(): Call<List<Cat>>

}