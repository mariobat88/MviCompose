package com.example.myapplication.main

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.appslabs.framework.BaseFragment
import com.example.myapplication.main.MainMvi.Intent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.channels.Channel

@AndroidEntryPoint
class MainFragment : BaseFragment<MainViewModel, MainMvi.ViewState, Intent>() {

    override val intentsChannel = Channel<Intent>(Channel.UNLIMITED)

    override fun getContent(): @Composable () -> Unit {
        return { NewsStory(intentsChannel) }
    }

    override fun viewModel(): MainViewModel {
        return viewModels<MainViewModel>().value
    }

}