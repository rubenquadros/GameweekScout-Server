package io.github.rubenquadros.gameweekscout.server.fpl.model.simple

import ai.koog.agents.core.tools.annotations.LLMDescription
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplElement
import kotlinx.serialization.Serializable

@Serializable
@LLMDescription("An individual football player (referred to as an 'element' in the API).")
data class PlayerEntity(
    @property:LLMDescription("Internal unique ID used to link the player across different API endpoints (e.g., live scoring).")
    val id: Int,
    @property:LLMDescription("The player's first name.")
    val firstName: String,
    @property:LLMDescription("The player's surname.")
    val secondName: String,
    @property:LLMDescription("The ID of the team the player plays for.")
    val team: Int,
    @property:LLMDescription("The player's position (GKP, DEF, MID, FWD).")
    val element: String,
    @property:LLMDescription("Percentage probability (0-100) that the player will feature in the current gameweek.")
    val chanceOfPlayingThisRound: Int?,
    @property:LLMDescription("Percentage probability (0-100) that the player will feature in the next gameweek. Null if 100%.")
    val chanceOfPlayingNextRound: Int?,
    @property:LLMDescription("Average points per match over recent games.")
    val form: String?,
    @property:LLMDescription("The player's current price in units of 0.1m (e.g., 125 = £12.5m).")
    val nowCost: Float,
    @property:LLMDescription("Average points earned per match played.")
    val pointsPerGame: String,
    @property:LLMDescription("Total points earned by the player this season.")
    val totalPoints: Int,
)

internal fun FplElement.toPlayerEntity() = PlayerEntity(
    id = id,
    firstName = firstName.orEmpty(),
    secondName = secondName.orEmpty(),
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
