package com.appslabs.framework

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

internal class MviLifecycleListener<VS, I>(
    private val component: MviComponent<VS, I>
) : FragmentManager.FragmentLifecycleCallbacks() {

    private val _intents = component.intentsChannel

    private var viewModelJob: Job? = null

    override fun onFragmentViewCreated(
        fm: FragmentManager,
        f: Fragment,
        v: View,
        savedInstanceState: Bundle?
    ) {
        if (viewModelJob == null) {
            viewModelJob = GlobalScope.launch(Dispatchers.Main) {
                component.viewModel().bind(_intents.consumeAsFlow())
            }
        }
    }

    override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
        viewModelJob?.cancel()
        viewModelJob = null
    }
}