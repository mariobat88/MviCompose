package com.appslabs.framework

import kotlinx.coroutines.flow.StateFlow

interface MviViewModel<VS> {
    val viewState: StateFlow<VS>
}