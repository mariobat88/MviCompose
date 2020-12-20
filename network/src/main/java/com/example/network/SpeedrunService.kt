package com.example.network

import com.example.network.model.GamesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SpeedrunService {

    @GET("/api/v1/games")
    fun getGames(@Query("offset") offset: Int): Call<GamesResponse>
}