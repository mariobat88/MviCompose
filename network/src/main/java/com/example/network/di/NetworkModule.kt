package com.example.network.di

import com.example.network.SpeedrunService
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
    }

    @Singleton
    @Provides
    fun provideSpeedrunService(client: Lazy<OkHttpClient>): SpeedrunService {
        return Retrofit.Builder()
            .baseUrl("https://www.speedrun.com/api/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .callFactory { client.get().newCall(it) }
            .build()
            .create(SpeedrunService::class.java)
    }
}