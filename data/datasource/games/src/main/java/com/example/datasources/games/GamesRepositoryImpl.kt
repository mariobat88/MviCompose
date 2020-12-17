package com.example.datasources.games

import com.example.games.GamesRepository
import com.example.network.SpeedrunService
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val speedrunService: SpeedrunService
) : GamesRepository {

    override suspend fun getGames(): Any {
        return speedrunService.getGames(0)
    }

}