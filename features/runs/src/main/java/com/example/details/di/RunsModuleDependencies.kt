package com.example.details.di

import com.example.games.GamesRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface RunsModuleDependencies {
    fun gamesRepository(): GamesRepository
}