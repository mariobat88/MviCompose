package com.appslabs.framework.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.AmbientViewModelStoreOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory

interface ViewModelComponent<VM : ViewModel> {
    fun viewModel(): VM
}

@Composable
inline fun <reified VM : ViewModel> viewModelFromComponent(component: ViewModelComponent<VM>): VM {
    return ViewModelProvider(
        AmbientViewModelStoreOwner.current,
        SpeedrunViewModelFactory(component)
    ).get(VM::class.java)
}

class SpeedrunViewModelFactory(private val component: ViewModelComponent<*>) : Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.cast(component.viewModel()) as T
    }
}

