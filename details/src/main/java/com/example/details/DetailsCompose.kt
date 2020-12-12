package com.example.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel

@Composable
fun DetailsCompose() {
    val viewModel: DetailsViewModel = viewModel()
    val viewState = viewModel.viewState.collectAsState().value

    MaterialTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = viewState.title,
                style = MaterialTheme.typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                "Details description",
                style = MaterialTheme.typography.body2
            )
            Text(
                "December 2020",
                style = MaterialTheme.typography.body2
            )
        }
    }
}