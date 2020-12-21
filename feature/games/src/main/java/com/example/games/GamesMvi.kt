package com.example.games

import com.appslabs.framework.Mvi
import com.example.games.model.SpeedrunGames

interface GamesMvi {
    data class ViewState(
        val games: List<SpeedrunGames.DataItem>? = null
    ) : Mvi.MviViewState
}