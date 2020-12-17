package com.example.details.di

import com.example.network.SpeedrunService
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface DetailsModuleDependencies {
    fun speedrunService(): SpeedrunService
}