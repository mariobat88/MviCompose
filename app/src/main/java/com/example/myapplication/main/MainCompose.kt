package com.example.myapplication.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Preview
import com.example.myapplication.R
import kotlinx.coroutines.channels.Channel


@Composable
fun NewsStory(intentChannel: Channel<MainMvi.Intent>) {
    val viewModel: MainViewModel = viewModel()
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
                style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                "Davenport, California",
                style = typography.body2
            )
            Text(
                "December 2018",
                style = typography.body2
            )
            Button(
                onClick = { intentChannel.offer(MainMvi.Intent.ButtonClick) }
            ) {
                Text(text = "Click me")
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    NewsStory(Channel(Channel.UNLIMITED))
}