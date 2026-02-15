package io.github.rubenquadros.gameweekscout.server.fpl.model.simple

import ai.koog.agents.core.tools.annotations.LLMDescription
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplScoring
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.PlayerScores
import kotlinx.serialization.Serializable

@Serializable
@LLMDescription("The scoring engine configuration. This defines exactly how many points a player earns for actions.")
data class ScoreEntity(
    @property:LLMDescription("Points for playing 60 minutes or more (usually 2).")
    val longPlay: Int,
    @property:LLMDescription("Points for playing less than 60 minutes (usually 1).")
    val shortPlay: Int,
    @property:LLMDescription("Points deducted for every 2 goals conceded, broken down by position.")
    val goalsConceded: PlayerScores,
    @property:LLMDescription("Points awarded to a Goalkeeper for every 3 saves made (usually 1).")
    val saves: Int,
    @property:LLMDescription("Points for scoring a goal, broken down by position: GKP, DEF, MID, FWD.")
    val goalsScored: PlayerScores,
    @property:LLMDescription("Points awarded for an assist (usually 3).")
    val assists: Int,
    @property:LLMDescription("Points for a clean sheet, broken down by position.")
    val cleanSheets: PlayerScores,
    @property:LLMDescription("Points a Goalkeeper earns for saving a penalty (usually 5).")
    val penaltiesSaved: Int,
    @property:LLMDescription("Points deducted for missing a penalty (usually -2).")
    val penaltiesMissed: Int,
    @property:LLMDescription("Points deducted for a yellow card (usually -1).")
    val yellowCards: Int,
    @property:LLMDescription("Points deducted for a red card (usually -3).")
    val redCards: Int,
    @property:LLMDescription("Points deducted for scoring an own goal (usually -2).")
    val ownGoals: Int,
    @property:LLMDescription("Points awarded for specialized defensive metrics, categorized by player position.")
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
