package com.example.details

import com.appslabs.framework.Mvi
import com.example.games.model.SpeedrunGames

interface RunsMvi {
    data class ViewState(
        val games: List<SpeedrunGames.DataItem>? = null
    ) : Mvi.MviViewState
}