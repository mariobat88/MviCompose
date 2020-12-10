package com.appslabs.framework

import kotlinx.coroutines.channels.Channel

interface MviComponent<VS, I> {
    val intentsChannel: Channel<I>
    fun viewModel(): MviViewModel<VS, I>
}