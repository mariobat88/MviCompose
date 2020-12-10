package com.example.myapplication.activity

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.ui.tooling.preview.Preview
import com.example.myapplication.main.DetailsCompose


@Composable
fun MainCompose() {
    val navController = rememberNavController()

    MaterialTheme {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                HomeComposable(navController)
            }
            composable("details") {
                DetailsCompose()
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MainCompose()
}