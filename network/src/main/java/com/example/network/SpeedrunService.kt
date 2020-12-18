package com.example.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SpeedrunService {

    @GET("/games")
    fun getGames(@Query("offset") offset: Int): Call<Any>
}