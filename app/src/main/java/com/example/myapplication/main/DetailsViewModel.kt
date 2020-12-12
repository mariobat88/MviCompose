package com.example.myapplication.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.appslabs.framework.MviViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext

class DetailsViewModel @ViewModelInject constructor(

) : ViewModel(), MviViewModel<DetailsMvi.ViewState> {

    override val viewState = MutableStateFlow(DetailsMvi.ViewState())
}

private suspend fun longWork() {
    return withContext(Dispatchers.IO) {
        Thread.sleep(2000)
    }
}