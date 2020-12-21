package com.example.myapplication.activity

import androidx.annotation.StringRes
import com.example.myapplication.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Runs : Screen("runs", R.string.runs)
    object Games : Screen("games", R.string.games)
}

val items = listOf(Screen.Runs, Screen.Games)