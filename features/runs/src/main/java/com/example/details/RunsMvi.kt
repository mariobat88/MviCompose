package com.example.details

import com.appslabs.framework.Mvi

interface RunsMvi {
    data class ViewState(
        val title: String = "Hello Details",
    ) : Mvi.MviViewState
}