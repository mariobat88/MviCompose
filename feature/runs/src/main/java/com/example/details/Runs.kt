package com.example.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.appslabs.framework.viewmodel.viewModelFromComponent
import com.example.details.di.RunsComponent
import com.example.games.model.SpeedrunGames
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
                    GameRow(it)
                    Divider(
                        modifier = Modifier.padding(
                            start = 10.dp,
                            end = 10.dp
                        ),
                        color = Color.Black,
                        thickness = 1.dp
                    )
                }
            }
        }
    }
}

@Composable
fun GameRow(gameData: SpeedrunGames.DataItem) {
    Column(
        modifier = Modifier.preferredHeight(200.dp)
            .fillMaxWidth()
            .background(
                color = Color(ContextCompat.getColor(AmbientContext.current, R.color.purple)),
                CutCornerShape(bottomLeft = 10.dp, bottomRight = 10.dp)
            )
            .padding(end = 10.dp)
    ) {
        Spacer(Modifier.height(10.dp))

        Row {
            val asset = gameData.assets?.getCover()

            val imageModifier = Modifier
                .width(150.dp)
                .height(150.dp)

            val image =
                loadImage(asset?.uri ?: "", asset?.width, asset?.height, imageModifier)

            Spacer(Modifier.width(10.dp))

            image.value?.let { bitmap ->
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(Modifier.width(10.dp))

            Text(
                text = gameData.names?.international ?: "",
                style = MaterialTheme.typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}