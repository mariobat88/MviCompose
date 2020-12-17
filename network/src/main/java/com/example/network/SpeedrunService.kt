package com.example.network

import retrofit2.http.GET
import retrofit2.http.Query

interface SpeedrunService {

    @GET("/games")
    fun get(@Query("offset") offset: Int) : Any
}