package com.example.datasources.games.di

import com.example.datasources.games.GamesRepositoryImpl
import com.example.games.GamesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class GamesRepositoryModule {

    @Singleton
    @Provides
    fun bindGamesRepository(impl: GamesRepositoryImpl): GamesRepository {
        return impl
    }
}