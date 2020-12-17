package com.example.games

interface GamesRepository {
    suspend fun getGames(): Any
}