package com.example.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appslabs.framework.MviViewModel
import com.appslabs.framework.edit
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
        viewModelScope.launch {
            runCatching { gamesRepository.getGames() }
                .onSuccess { speedrunGames ->
                    viewState.edit {
                        it.copy(
                            games = speedrunGames.data?.filterNotNull()!!
                        )
                    }
                }
        }
    }

}