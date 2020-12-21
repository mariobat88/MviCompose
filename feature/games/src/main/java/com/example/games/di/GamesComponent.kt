package com.example.games.di

import android.content.Context
import com.appslabs.framework.viewmodel.ViewModelComponent
import com.example.games.GamesViewModel
import dagger.Component
import dagger.hilt.android.EntryPointAccessors

@Component(dependencies = [GamesDependencies::class])
interface GamesComponent : ViewModelComponent<GamesViewModel> {

    @Component.Factory
    interface Factory {
        fun create(
            gamesDependencies: GamesDependencies
        ): GamesComponent
    }

    companion object {
        operator fun invoke(applicationContext: Context): GamesComponent {
            return DaggerGamesComponent.factory().create(
                gamesDependencies = EntryPointAccessors.fromApplication(
                    applicationContext,
                    GamesDependencies::class.java
                )
            )
        }
    }
}
