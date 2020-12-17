package com.example.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.appslabs.framework.MviViewModel
import com.example.network.SpeedrunService
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val speedrunService: SpeedrunService
) : ViewModel(), MviViewModel<DetailsMvi.ViewState> {

    override val viewState = MutableStateFlow(DetailsMvi.ViewState())
}