package com.example.games.mapper

import com.example.common.model.LinksItem
import com.example.games.model.SpeedrunGames
import com.example.network.model.GamesResponse
import com.example.network.model.commons.LinksItemResponse

fun GamesResponse.toSpeedrunGames(): SpeedrunGames {
    return SpeedrunGames(
        pagination = pagination?.toPagination(),
        data =
    )
}

private fun GamesResponse.Pagination.toPagination(): SpeedrunGames.Pagination {
    return SpeedrunGames.Pagination(
        offset = offset,
        size = size,
        max = max,
        links = links?.map { it?.toLinksItem() }
    )
}

private fun LinksItemResponse.toLinksItem(): LinksItem {
    return LinksItem(
        rel = rel,
        uri = uri
    )
}

private fun GamesResponse.DataItem.toDataItem(): SpeedrunGames.DataItem {
    return SpeedrunGames.DataItem(
        regions = regions,
        developers = developers,
        releaseDate = releaseDate,
        created = created,
        ruleset = ruleset?.toRuleset(),
        abbreviation = abbreviation,
        platforms = platforms,
        romhack = romhack,
        gametypes = gametypes,
        names = names?.toNames(),
        assets = assets,
        genres = genres,
        engines = engines,
        weblink = weblink,
        publishers = publishers,
        links = links?.map { it?.toLinksItem() },
        id = id,
        released = released,
    )
}

private fun GamesResponse.DataItem.Ruleset.toRuleset(): SpeedrunGames.DataItem.Ruleset {
    return SpeedrunGames.DataItem.Ruleset(
        emulatorsAllowed = emulatorsAllowed,
        defaultTime = defaultTime,
        showMilliseconds = showMilliseconds,
        requireVerification = requireVerification,
        requireVideo = requireVideo,
        runTimes = runTimes

    )
}

private fun GamesResponse.DataItem.Names.toNames(): SpeedrunGames.DataItem.Names {
    return SpeedrunGames.DataItem.Names(
        japanese = japanese,
        twitch = twitch,
        international = international
    )
}

private fun GamesResponse.DataItem.Assets.toAssets(): SpeedrunGames.DataItem.Assets {
    return SpeedrunGames.DataItem.Assets(
        coverSmall = coverSmall?.toCover(),
        trophy1st = trophy1st?.toTrophy(),
        background = background?.toBackground(),
        coverMedium = coverMedium?.toCover(),
        icon = icon,
        trophy2nd = trophy2nd?.toTrophy(),
        trophy4th = trophy4th?.toTrophy(),
        logo = logo,
        trophy3rd = trophy3rd?.toTrophy(),
        foreground = foreground?.toForeground(),
        coverTiny = coverTiny?.toCover(),
        coverLarge = coverLarge?.toCover(),
    )
}

private fun GamesResponse.DataItem.Cover.toCover(): SpeedrunGames.DataItem.Cover {
    return SpeedrunGames.DataItem.Cover(
        width = width,
        uri = uri,
        height = height
    )
}

private fun GamesResponse.DataItem.Trophy.toTrophy(): SpeedrunGames.DataItem.Trophy {
    return SpeedrunGames.DataItem.Trophy(
        width = width,
        uri = uri,
        height = height
    )
}

private fun GamesResponse.DataItem.Foreground.toForeground(): SpeedrunGames.DataItem.Foreground {
    return SpeedrunGames.DataItem.Foreground(
        width = width,
        uri = uri,
        height = height
    )
}

private fun GamesResponse.DataItem.Background.toBackground(): SpeedrunGames.DataItem.Background {
    return SpeedrunGames.DataItem.Background(
        width = width,
        uri = uri,
        height = height
    )
}