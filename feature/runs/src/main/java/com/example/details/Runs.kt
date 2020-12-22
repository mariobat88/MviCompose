package com.example.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.appslabs.framework.viewmodel.viewModelFromComponent
import com.example.details.di.RunsComponent
import com.example.ui.loadImage

@Composable
fun RunsScreen() {
    val viewModel: RunsViewModel =
        viewModelFromComponent(RunsComponent(AmbientContext.current.applicationContext))
    val viewState = viewModel.viewState.collectAsState().value

    MaterialTheme {
        if (viewState.games?.isNullOrEmpty() == false) {
            LazyColumn {
                items(viewState.games) {
                    val asset = it.assets?.getCover()

                    val imageModifier = Modifier
                        .width(150.dp)
                        .height(150.dp)

                    val image =
                        loadImage(asset?.uri ?: "", asset?.width, asset?.height, imageModifier)
                    image.value?.let { bitmap ->
                        Image(
                            bitmap = bitmap.asImageBitmap(),
                            modifier = imageModifier,
                            contentScale = ContentScale.Crop
                        )
                    }

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
}