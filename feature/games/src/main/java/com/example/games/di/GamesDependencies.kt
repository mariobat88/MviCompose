package com.example.games.di

import com.example.games.GamesRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface GamesDependencies {
    fun gamesRepository(): GamesRepository
}