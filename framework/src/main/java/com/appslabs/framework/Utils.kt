package com.appslabs.framework

import kotlinx.coroutines.flow.MutableStateFlow

inline fun <T> MutableStateFlow<T>.edit(block: (T) -> (T)) {
    value = block(value)
}
