package com.example.myapplication.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.appslabs.framework.MviViewModel
import com.example.myapplication.main.MainMvi.Intent
import com.example.myapplication.main.MainMvi.ViewState
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @ViewModelInject constructor(

) : ViewModel(), MviViewModel<ViewState, Intent> {

    override val viewState = MutableStateFlow(ViewState())

    override suspend fun bind(intents: Flow<Intent>): Job =
        coroutineScope {
            launch {

                intents.collect { intent ->
                    when (intent) {
                        is Intent.ButtonClick -> {
                            viewState.value = viewState.value.copy(
                                title = "Hello again"
                            )
                        }
                    }
                }
            }
        }

}