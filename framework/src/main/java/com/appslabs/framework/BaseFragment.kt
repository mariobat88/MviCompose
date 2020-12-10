package com.appslabs.framework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<VM : ViewModel, VS : Mvi.MviViewState, I : Mvi.MviIntent> : Fragment(),
    MviComponent<VS, I> {

    abstract fun getContent(): @Composable () -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        parentFragmentManager.registerFragmentLifecycleCallbacks(MviLifecycleListener(this), false)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(container!!.context).apply {
            setContent { getContent().invoke() }
        }
    }
}