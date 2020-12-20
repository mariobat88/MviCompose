package com.example.games.model

import com.example.common.model.Asset
import com.example.common.model.LinksItem

data class SpeedrunGames(
    val pagination: Pagination? = null,
    val data: List<DataItem?>? = null
) {

    data class Pagination(
        val offset: Int? = null,
        val size: Int? = null,
        val max: Int? = null,
        val links: List<LinksItem?>? = null
    )

    data class DataItem(
        val regions: List<Any?>? = null,
        val developers: List<String?>? = null,
        val releaseDate: String? = null,
        val created: String? = null,
        val ruleset: Ruleset? = null,
        val abbreviation: String? = null,
        val platforms: List<String?>? = null,
        val romhack: Boolean? = null,
        val gametypes: List<Any?>? = null,
        val names: Names? = null,
        val assets: Assets? = null,
        val genres: List<Any?>? = null,
        val engines: List<String?>? = null,
        val weblink: String? = null,
        val publishers: List<Any?>? = null,
        val links: List<LinksItem?>? = null,
        val id: String? = null,
        val released: Int? = null,
    ) {

        data class Ruleset(
            val emulatorsAllowed: Boolean? = null,
            val defaultTime: String? = null,
            val showMilliseconds: Boolean? = null,
            val requireVerification: Boolean? = null,
            val requireVideo: Boolean? = null,
            val runTimes: List<String?>? = null
        )

        data class Assets(
            val coverSmall: Asset? = null,
            val trophy1st: Asset? = null,
            val background: Asset? = null,
            val coverMedium: Asset? = null,
            val icon: Asset? = null,
            val trophy2nd: Asset? = null,
            val trophy4th: Asset? = null,
            val logo: Asset? = null,
            val trophy3rd: Asset? = null,
            val foreground: Asset? = null,
            val coverTiny: Asset? = null,
            val coverLarge: Asset? = null
        )

        data class Names(
            val japanese: String? = null,
            val twitch: String? = null,
            val international: String? = null
        )
    }
}