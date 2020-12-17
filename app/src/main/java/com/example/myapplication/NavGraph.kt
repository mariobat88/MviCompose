package com.example.myapplication

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import androidx.ui.tooling.preview.Preview
import com.example.myapplication.MainDestinations.DETAILS
import com.example.myapplication.MainDestinations.HOME
import com.example.myapplication.activity.HomeComposable
import com.example.details.DetailsCompose
import com.example.myapplication.activity.Screen
import com.example.myapplication.activity.items

object MainDestinations {
    const val HOME = "home"
    const val DETAILS = "details"
}

@Composable
fun NavGraph(

) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.Home) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            // This if check gives us a "singleTop" behavior where we do not create a
                            // second instance of the composable if we are already on that destination
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route)
                            }
                        }
                    )
                }
            }
        }
    ) {
        NavHost(navController, startDestination = Screen.Games.route) {
            composable(Screen.Games.route) { HomeComposable(navController) }
            composable(Screen.Runs.route) { DetailsCompose() }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    NavGraph()
}