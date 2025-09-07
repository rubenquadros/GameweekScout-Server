package io.github.rubenquadros.gameweekscout.server.ai.model.fpl

import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplElement
import kotlinx.serialization.Serializable

@Serializable
internal data class PlayerEntity(
    val id: Int,
    val name: String,
    val team: Int,
    val element: String,
    val chanceOfPlayingThisRound: Int?,
    val chanceOfPlayingNextRound: Int?,
    val epNext: String,
    val epThis: String,
    val eventPoints: Int,
    val form: String?,
    val nowCost: Float,
    val pointsPerGame: String,
    val selectedByPercent: String,
    val totalPoints: Int,
    val minutes: Long,
    val goalsScored: Int,
    val assists: Int,
    val cleanSheets: Int,
    val goalsConceded: Int,
    val ownGoals: Int,
    val penaltiesSaved: Int,
    val penaltiesMissed: Int,
    val saves: Int,
    val yellowCards: Int,
    val redCards: Int,
    val clearancesBlocksInterceptions: Int,
    val recoveries: Int,
    val tackles: Int,
    val starts: Int,
    val defensiveContribution: Int
)

internal fun FplElement.toPlayerEntity() = PlayerEntity(
    id = id,
    name = "$firstName $secondName",
    team = team,
    element = when (elementType) {
        1 -> "GKP"
        2 -> "DEF"
        3 -> "MID"
        4 -> "FWD"
        else -> ""
    },
    form = form,
    chanceOfPlayingNextRound = chanceOfPlayingNextRound,
    chanceOfPlayingThisRound = chanceOfPlayingThisRound,
    epThis = epThis,
    epNext = epNext,
    totalPoints = totalPoints,
    eventPoints = eventPoints,
    nowCost = nowCost/10f,
    goalsScored = goalsScored,
    goalsConceded = goalsConceded,
    ownGoals = ownGoals,
    assists = assists,
    saves = saves,
    penaltiesSaved = penaltiesSaved,
    penaltiesMissed = penaltiesSaved,
    selectedByPercent = selectedByPercent,
    yellowCards = yellowCards,
    redCards = redCards,
    pointsPerGame = pointsPerGame,
    starts = starts,
    cleanSheets = cleanSheets,
    minutes = minutes,
    clearancesBlocksInterceptions = clearancesBlocksInterceptions,
    recoveries = recoveries,
    tackles = tackles,
    defensiveContribution = defensiveContribution
)
