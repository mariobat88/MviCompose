package com.example.games

import com.example.common.model.Asset
import com.example.games.model.SpeedrunGames

fun SpeedrunGames.DataItem.Assets.getCover(): Asset? {
    return coverLarge ?: coverMedium ?: coverSmall ?: coverTiny
}