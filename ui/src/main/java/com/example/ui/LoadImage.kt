package com.example.ui

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.WithConstraints
import androidx.compose.ui.platform.AmbientContext
import androidx.core.graphics.drawable.toBitmap
import coil.Coil
import coil.request.ImageRequest
import coil.target.Target

@Composable
fun loadImage(
    url: String,
    modifier: Modifier
): MutableState<Bitmap?> {
    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)
    val context = AmbientContext.current
    Log.d("BATBAT", url)

    WithConstraints(modifier) {
        onCommit(url) {

            val target = object : Target {
                override fun onSuccess(result: Drawable) {
                    super.onSuccess(result)
                    bitmapState.value = result.toBitmap()
                }
            }

            val request = ImageRequest.Builder(context)
                .data(url)
                .size(maxWidth.value.toInt(), maxHeight.value.toInt())
                .target(target)

            val disposable = Coil.imageLoader(context).enqueue(request.build())

            onDispose {
                disposable.dispose()
            }
        }
    }
    return bitmapState
}