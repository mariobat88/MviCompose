package com.example.network.model

import com.example.network.model.commons.LinksItemResponse

data class GamesResponse(
    val pagination: Pagination? = null,
    val data: List<DataItem?>? = null
) {

    data class Pagination(
        val offset: Int? = null,
        val size: Int? = null,
        val max: Int? = null,
        val links: List<LinksItemResponse?>? = null
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
        val links: List<LinksItemResponse?>? = null,
        val id: String? = null,
        val released: Int? = null,
    ) {

        data class Background(
            val width: Int? = null,
            val uri: String? = null,
            val height: Int? = null
        )

        data class Ruleset(
            val emulatorsAllowed: Boolean? = null,
            val defaultTime: String? = null,
            val showMilliseconds: Boolean? = null,
            val requireVerification: Boolean? = null,
            val requireVideo: Boolean? = null,
            val runTimes: List<String?>? = null
        )

        data class Assets(
            val coverSmall: Cover? = null,
            val trophy1st: Trophy? = null,
            val background: Background? = null,
            val coverMedium: Cover? = null,
            val icon: Icon? = null,
            val trophy2nd: Trophy? = null,
            val trophy4th: Trophy? = null,
            val logo: Logo? = null,
            val trophy3rd: Trophy? = null,
            val foreground: Foreground? = null,
            val coverTiny: Cover? = null,
            val coverLarge: Cover? = null
        )

        data class Cover(
            val width: Int? = null,
            val uri: String? = null,
            val height: Int? = null
        )

        data class Icon(
            val width: Int? = null,
            val uri: String? = null,
            val height: Int? = null
        )

        data class Names(
            val japanese: String? = null,
            val twitch: String? = null,
            val international: String? = null
        )

        data class Trophy(
            val width: Int? = null,
            val uri: String? = null,
            val height: Int? = null
        )

        data class Logo(
            val width: Int? = null,
            val uri: String? = null,
            val height: Int? = null
        )

        data class Foreground(
            val width: Int? = null,
            val uri: String? = null,
            val height: Int? = null
        )
    }
}