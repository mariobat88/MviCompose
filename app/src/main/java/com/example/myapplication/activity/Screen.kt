package com.example.myapplication.activity

import androidx.annotation.StringRes
import com.example.myapplication.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Games : Screen("games", R.string.games)
    object Runs : Screen("runs", R.string.runs)
}

val items = listOf(Screen.Games, Screen.Runs)