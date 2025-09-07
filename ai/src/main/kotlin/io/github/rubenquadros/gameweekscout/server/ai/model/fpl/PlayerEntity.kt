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
    val form: String?,
    val nowCost: Float,
    val pointsPerGame: String,
    val totalPoints: Int,
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
    nowCost = nowCost/10f,
    pointsPerGame = pointsPerGame,
    totalPoints = totalPoints
)
