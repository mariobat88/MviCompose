package com.example.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.appslabs.framework.viewmodel.viewModelFromComponent
import com.example.details.di.RunsComponent
import kotlinx.coroutines.launch

@Composable
fun Runs() {
    val viewModel: RunsViewModel = viewModelFromComponent(RunsComponent(AmbientContext.current.applicationContext))
    val viewState = viewModel.viewState.collectAsState().value

    MaterialTheme {
        if(viewState.games?.isNullOrEmpty() == false){
            LazyColumnFor(items = viewState.games) {
                Text(
                    text = it.names?.international ?: "",
                    style = MaterialTheme.typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}