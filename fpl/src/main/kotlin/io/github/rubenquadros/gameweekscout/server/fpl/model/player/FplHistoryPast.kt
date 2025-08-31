package io.github.rubenquadros.gameweekscout.server.fpl.model.player

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplHistoryPast(
    @SerialName("season_name")
    val seasonName: String,
    @SerialName("element_code")
    val elementCode: Int,
    @SerialName("start_cost")
    val startCost: Float,
    @SerialName("end_cost")
    val endCost: Float,
    @SerialName("total_points")
    val totalPoints: Int,
    @SerialName("minutes")
    val minutes: Int,
    @SerialName("goals_scored")
    val goalsScored: Int,
    @SerialName("assists")
    val assists: Int,
    @SerialName("clean_sheets")
    val cleanSheets: Int,
    @SerialName("goals_conceded")
    val goalsConceded: Int,
    @SerialName("own_goals")
    val ownGoals: Int,
    @SerialName("penalties_saved")
    val penaltiesSaved: Int,
    @SerialName("penalties_missed")
    val penaltiesMissed: Int,
    @SerialName("yellow_cards")
    val yellowCards: Int,
    @SerialName("red_cards")
    val redCards: Int,
    @SerialName("saves")
    val saves: Int,
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
    @SerialName("clearances_blocks_interceptions")
    val clearanceBlocksInterceptions: Int,
    @SerialName("recoveries")
    val recoveries: Int,
    @SerialName("tackles")
    val tackles: Int,
    @SerialName("defensive_contribution")
    val defensiveContribution: Int,
    @SerialName("starts")
    val starts: Int,
    @SerialName("expected_assists")
    val expectedAssists: String,
    @SerialName("expected_goal_involvements")
    val expectedGoalInvolvements: String,
    @SerialName("expected_goals_conceded")
    val expectedGoalsConceded: String,
    @SerialName("expected_goals")
    val expectedGoals: String,
)
