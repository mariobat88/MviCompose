package com.example.myapplication.main

import com.appslabs.framework.Mvi

interface DetailsMvi {
    sealed class Intent : Mvi.MviIntent

    data class ViewState(
        val title: String = "Hello Details",
    ) : Mvi.MviViewState
}