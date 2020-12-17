package com.example.details

import androidx.lifecycle.ViewModel
import com.appslabs.framework.MviViewModel
import com.example.games.GamesRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RunsViewModel @Inject constructor(
    private val gamesRepository: GamesRepository
) : ViewModel(), MviViewModel<RunsMvi.ViewState> {

    override val viewState = MutableStateFlow(RunsMvi.ViewState())

    init {
        coroutineScope {
            launch {
                gamesRepository.getGames()
            }
        }

    }

}