package io.github.rubenquadros.gameweekscout.server.ai.model.fpl

import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplScoring
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.PlayerScores
import kotlinx.serialization.Serializable

@Serializable
internal data class ScoreEntity(
    val longPlay: Int,
    val shortPlay: Int,
    val goalsConceded: PlayerScores,
    val saves: Int,
    val goalsScored: PlayerScores,
    val assists: Int,
    val cleanSheets: PlayerScores,
    val penaltiesSaved: Int,
    val penaltiesMissed: Int,
    val yellowCards: Int,
    val redCards: Int,
    val ownGoals: Int,
    val defensiveContributions: PlayerScores
)

internal fun FplScoring.toScoreEntity() = ScoreEntity(
    longPlay = longPlay,
    shortPlay = shortPlay,
    goalsScored = goalsScored,
    goalsConceded = goalsConceded,
    ownGoals = ownGoals,
    saves = saves,
    penaltiesSaved = penaltiesSaved,
    penaltiesMissed = penaltiesSaved,
    yellowCards = yellowCards,
    redCards = redCards,
    defensiveContributions = defensiveContributions,
    assists = assists,
    cleanSheets = cleanSheets
)
