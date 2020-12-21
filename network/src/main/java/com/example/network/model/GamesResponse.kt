package com.example.network.model

import com.example.network.model.commons.LinksItemResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class GamesResponse(
    @field:Json(name = "pagination")
    val pagination: Pagination? = null,
    @field:Json(name = "data")
    val data: List<DataItem?>? = null
) {

    data class Pagination(
        @field:Json(name = "offset")
        val offset: Int? = null,
        @field:Json(name = "size")
        val size: Int? = null,
        @field:Json(name = "max")
        val max: Int? = null,
        @field:Json(name = "links")
        val links: List<LinksItemResponse?>? = null
    )

    data class DataItem(
        @field:Json(name = "regions")
        val regions: List<Any?>? = null,
        @field:Json(name = "developers")
        val developers: List<String?>? = null,
        @field:Json(name = "release-date")
        val releaseDate: String? = null,
        @field:Json(name = "created")
        val created: String? = null,
        @field:Json(name = "ruleset")
        val ruleset: Ruleset? = null,
        @field:Json(name = "abbreviation")
        val abbreviation: String? = null,
        @field:Json(name = "platforms")
        val platforms: List<String?>? = null,
        @field:Json(name = "romhack")
        val romhack: Boolean? = null,
        @field:Json(name = "gametypes")
        val gametypes: List<Any?>? = null,
        @field:Json(name = "names")
        val names: Names? = null,
        @field:Json(name = "assets")
        val assets: Assets? = null,
        @field:Json(name = "genres")
        val genres: List<Any?>? = null,
        @field:Json(name = "engines")
        val engines: List<String?>? = null,
        @field:Json(name = "weblink")
        val weblink: String? = null,
        @field:Json(name = "publishers")
        val publishers: List<Any?>? = null,
        @field:Json(name = "links")
        val links: List<LinksItemResponse?>? = null,
        @field:Json(name = "id")
        val id: String? = null,
        @field:Json(name = "released")
        val released: Int? = null,
    ) {

        data class Ruleset(
            @field:Json(name = "emulators-allowed")
            val emulatorsAllowed: Boolean? = null,
            @field:Json(name = "default-time")
            val defaultTime: String? = null,
            @field:Json(name = "show-milliseconds")
            val showMilliseconds: Boolean? = null,
            @field:Json(name = "require-verification")
            val requireVerification: Boolean? = null,
            @field:Json(name = "require-video")
            val requireVideo: Boolean? = null,
            @field:Json(name = "run-times")
            val runTimes: List<String?>? = null
        )

        data class Names(
            @field:Json(name = "japanese")
            val japanese: String? = null,
            @field:Json(name = "twitch")
            val twitch: String? = null,
            @field:Json(name = "international")
            val international: String? = null
        )

        data class Assets(
            @field:Json(name = "cover-small")
            val coverSmall: Asset? = null,
            @field:Json(name = "trophy-1st")
            val trophy1st: Asset? = null,
            @field:Json(name = "background")
            val background: Asset? = null,
            @field:Json(name = "cover-medium")
            val coverMedium: Asset? = null,
            @field:Json(name = "icon")
            val icon: Asset? = null,
            @field:Json(name = "trophy-2nd")
            val trophy2nd: Asset? = null,
            @field:Json(name = "trophy-4th")
            val trophy4th: Asset? = null,
            @field:Json(name = "logo")
            val logo: Asset? = null,
            @field:Json(name = "trophy-3rd")
            val trophy3rd: Asset? = null,
            @field:Json(name = "foreground")
            val foreground: Asset? = null,
            @field:Json(name = "cover-tiny")
            val coverTiny: Asset? = null,
            @field:Json(name = "cover-large")
            val coverLarge: Asset? = null
        ) {

            data class Asset(
                @field:Json(name = "width")
                val width: Int? = null,
                @field:Json(name = "uri")
                val uri: String? = null,
                @field:Json(name = "height")
                val height: Int? = null
            )
        }
    }
}