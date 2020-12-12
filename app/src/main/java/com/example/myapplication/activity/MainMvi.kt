package com.example.myapplication.activity

import com.appslabs.framework.Mvi

interface MainMvi {
    data class ViewState(
        val title: String = "Hello Mario",
        val isLoading: Boolean = false
    ) : Mvi.MviViewState
}