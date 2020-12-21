package com.example.games

import com.example.games.model.SpeedrunGames

interface GamesRepository {
    suspend fun getGames(): SpeedrunGames
}