package com.appslabs.framework

import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MviViewModel<VS, I> {

    val viewState: StateFlow<VS>

    suspend fun bind(intents: Flow<I>): Job
}