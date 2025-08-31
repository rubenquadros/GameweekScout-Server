package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplScoring(
    @SerialName("long_play")
    val longPlay: Int,
    @SerialName("short_play")
    val shortPlay: Int,
    @SerialName("goals_conceded")
    val goalsConceded: PlayerScores,
    @SerialName("saves")
    val saves: Int,
    @SerialName("goals_scored")
    val goalsScored: PlayerScores,
    @SerialName("assists")
    val assists: Int,
    @SerialName("clean_sheets")
    val cleanSheets: PlayerScores,
    @SerialName("penalties_saved")
    val penaltiesSaved: Int,
    @SerialName("penalties_missed")
    val penaltiesMissed: Int,
    @SerialName("yellow_cards")
    val yellowCards: Int,
    @SerialName("red_cards")
    val redCards: Int,
    @SerialName("own_goals")
    val ownGoals: Int,
    @SerialName("bonus")
    val bonus: Int,
    @SerialName("bps")
    val bps: Int,
    @SerialName("influence")
    val influence: String,
    @SerialName("creativity")
    val creativity: String,
    @SerialName("threat")
    val threat: String,
    @SerialName("ict_index")
    val ictIndex: String,
    @SerialName("special_multiplier")
    val specialMultiplier: Int,
    @SerialName("tackles")
    val tackles: Int,
    @SerialName("clearances_blocks_interceptions")
    val clearancesBlocksInterceptions: Int,
    @SerialName("recoveries")
    val recoveries: Int,
    @SerialName("defensive_contribution")
    val defensiveContributions: PlayerScores,
    @SerialName("mng_goals_scored")
    val mngGoalsScored: PlayerScores,
    @SerialName("mng_clean_sheets")
    val mngCleanSheets: PlayerScores,
    @SerialName("mng_win")
    val mngWin: PlayerScores,
    @SerialName("mng_draw")
    val mngDraw: PlayerScores,
    @SerialName("mng_loss")
    val mngLoss: Int,
    @SerialName("mng_underdog_win")
    val mngUnderdogWin: PlayerScores,
    @SerialName("mng_underdog_draw")
    val mngUnderdogDraw: PlayerScores,
    @SerialName("starts")
    val starts: Int,
    @SerialName("expected_assists")
    val expectedAssists: String,
    @SerialName("expected_goal_involvements")
    val expectedGoalInvolvements: String,
    @SerialName("expected_goals_conceded")
    val expectedGoalsConceded: String,
    @SerialName("expected_goals")
    val expectedGoals: String
)

@Serializable
data class PlayerScores(
    @SerialName("DEF")
    val def: Int,
    @SerialName("FWD")
    val fwd: Int,
    @SerialName("GKP")
    val gkp: Int,
    @SerialName("MID")
    val mid: Int
)