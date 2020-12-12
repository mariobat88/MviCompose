package com.example.myapplication.activity

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.appslabs.framework.MviViewModel
import com.appslabs.framework.edit
import com.example.myapplication.activity.MainMvi.ViewState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel @ViewModelInject constructor(

) : ViewModel(), MviViewModel<ViewState> {

    override val viewState = MutableStateFlow(ViewState())

    suspend fun longWork() {
        viewState.edit {
            it.copy(
                isLoading = true
            )
        }
        withContext(Dispatchers.IO) {
            Thread.sleep(2000)
        }
        viewState.edit {
            it.copy(
                isLoading = false
            )
        }
    }

}