package com.example.myapplication.main

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.appslabs.framework.MviViewModel
import com.appslabs.framework.edit
import com.example.myapplication.activity.MainMvi
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect

class DetailsViewModel @ViewModelInject constructor(

) : ViewModel(), MviViewModel<DetailsMvi.ViewState, DetailsMvi.Intent> {

    override val viewState = MutableStateFlow(DetailsMvi.ViewState())

    override suspend fun bind(intents: Flow<DetailsMvi.Intent>): Job =
        coroutineScope {
            launch {
                intents.collect { intent ->
                    when (intent) {

                    }
                }
            }

            launch {
                val longWork = longWork()
                viewState.edit {
                    it.copy(
                        title = "Long work done"
                    )
                }
            }
        }

}

private suspend fun longWork() {
    return withContext(Dispatchers.IO) {
        Thread.sleep(2000)
    }
}