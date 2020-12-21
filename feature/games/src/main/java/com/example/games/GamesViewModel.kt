package com.example.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appslabs.framework.MviViewModel
import com.appslabs.framework.edit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class GamesViewModel @Inject constructor(
    private val gamesRepository: GamesRepository
) : ViewModel(), MviViewModel<GamesMvi.ViewState> {

    override val viewState = MutableStateFlow(GamesMvi.ViewState())

    init {
        viewModelScope.launch {
            runCatching { gamesRepository.getGames() }
                .onSuccess { speedrunGames ->
                    viewState.edit {
                        it.copy(
                            games = speedrunGames.data?.filterNotNull()!!,
                            isLoading = false
                        )
                    }
                }
        }
    }
}