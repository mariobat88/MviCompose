package com.example.details

import com.appslabs.framework.Mvi

interface DetailsMvi {
    data class ViewState(
        val title: String = "Hello Details",
    ) : Mvi.MviViewState
}