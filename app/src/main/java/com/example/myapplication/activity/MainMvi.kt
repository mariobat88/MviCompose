package com.example.myapplication.activity

import com.appslabs.framework.Mvi

interface MainMvi {
    sealed class Intent : Mvi.MviIntent {
        object ButtonClick : Intent()
    }

    data class ViewState(
        val title: String = "Hello Mario",
        val empty: Boolean = false
    ) : Mvi.MviViewState
}