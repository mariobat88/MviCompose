package com.example.myapplication

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.ui.tooling.preview.Preview
import com.example.myapplication.MainDestinations.DETAILS
import com.example.myapplication.MainDestinations.HOME
import com.example.myapplication.activity.HomeComposable
import com.example.details.DetailsCompose

object MainDestinations {
    const val HOME = "home"
    const val DETAILS = "details"
}

@Composable
fun NavGraph(

) {
    val navController = rememberNavController()

    MaterialTheme {
        NavHost(navController = navController, startDestination = HOME) {
            composable(HOME) {
                HomeComposable(navController)
            }
            composable(DETAILS) {
                DetailsCompose()
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    NavGraph()
}