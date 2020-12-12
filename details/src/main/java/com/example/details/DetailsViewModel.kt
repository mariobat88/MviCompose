package com.example.details

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