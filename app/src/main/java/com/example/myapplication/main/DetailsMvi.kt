package com.example.myapplication.main

import com.appslabs.framework.Mvi

interface DetailsMvi {
    data class ViewState(
        val title: String = "Hello Details",
    ) : Mvi.MviViewState
}