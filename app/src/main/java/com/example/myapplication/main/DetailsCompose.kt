package com.example.myapplication.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.example.myapplication.R
import com.example.myapplication.activity.MainMvi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

@Composable
fun DetailsCompose() {
    val coroutineScope = rememberCoroutineScope()
    val intentsChannel = Channel<DetailsMvi.Intent>(Channel.UNLIMITED)
    val viewModel: DetailsViewModel = viewModel()

    coroutineScope.launch {
        viewModel.bind(intentsChannel.consumeAsFlow())
    }

    val viewState = viewModel.viewState.collectAsState().value

    val image = imageResource(R.drawable.header)
    MaterialTheme {
        Column(modifier = Modifier.padding(16.dp)) {

            val imageModifier = Modifier
                .preferredHeight(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp))

            Image(
                image,
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.preferredHeight(16.dp))
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