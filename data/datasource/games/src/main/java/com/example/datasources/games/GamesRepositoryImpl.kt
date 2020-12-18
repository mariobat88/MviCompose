package com.example.datasources.games

import com.example.games.GamesRepository
import com.example.network.SpeedrunService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val speedrunService: SpeedrunService
) : GamesRepository {

    override suspend fun getGames(): Any {
        return withContext(Dispatchers.IO) {
            speedrunService.getGames(0).execute()
        }
    }

}