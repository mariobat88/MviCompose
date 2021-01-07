package com.example.games

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.appslabs.framework.viewmodel.viewModelFromComponent
import com.example.games.di.GamesComponent
import com.example.games.model.SpeedrunGames
import com.example.ui.loadImage

@Composable
fun GamesScreen() {
    val viewModel: GamesViewModel =
        viewModelFromComponent(GamesComponent(AmbientContext.current.applicationContext))
    val viewState = viewModel.viewState.collectAsState().value

    MaterialTheme {
        if (viewState.isLoading) {
            Loading()
        } else {
            GamesList(viewState.games)
        }
    }
}

@Composable
fun Loading() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LinearProgressIndicator(
            modifier = Modifier.width(100.dp)
        )
    }
}

@Composable
fun GamesList(games: List<SpeedrunGames.DataItem>?) {
    if (games?.isNullOrEmpty() == false) {
        LazyColumn {
            items(games) {
                GameRow(it)
            }
        }
    }
}


@Composable
fun GameRow(gameData: SpeedrunGames.DataItem) {
    Column(
        modifier = Modifier.preferredHeight(200.dp)
    ) {
        Row {
            val asset = gameData.assets?.getCover()

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
                text = gameData.names?.international ?: "",
                style = MaterialTheme.typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}