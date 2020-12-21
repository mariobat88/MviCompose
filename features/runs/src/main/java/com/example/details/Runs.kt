package com.example.details

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.preferredHeight
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
fun Runs() {
    val viewModel: RunsViewModel =
        viewModelFromComponent(RunsComponent(AmbientContext.current.applicationContext))
    val viewState = viewModel.viewState.collectAsState().value

    MaterialTheme {
        if (viewState.games?.isNullOrEmpty() == false) {
            LazyColumnFor(items = viewState.games) {

                val imageModifier = Modifier
                    .preferredHeight(180.dp)
                    .fillMaxWidth()

                val image = loadImage(it.assets?.getCover()?.uri ?: "", imageModifier)
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