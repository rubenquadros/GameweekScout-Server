package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplElement(
    @SerialName("can_transact")
    val canTransact: Boolean,
    @SerialName("can_select")
    val canSelect: Boolean,
    @SerialName("chance_of_playing_next_round")
    val chanceOfPlayingNextRound: Int?,
    @SerialName("chance_of_playing_this_round")
    val chanceOfPlayingThisRound: Int?,
    @SerialName("code")
    val code: Int,
    @SerialName("cost_change_event")
    val costChangeEvent: Int,
    @SerialName("cost_change_event_fall")
    val costChangeEventFall: Int,
    @SerialName("cost_change_start")
    val costChangeStart: Int,
    @SerialName("cost_change_start_fall")
    val costChangeStartFall: Int,
    @SerialName("dreamteam_count")
    val dreamTeamCount: Int,
    @SerialName("element_type")
    val elementType: Int,
    @SerialName("ep_next")
    val epNext: String,
    @SerialName("ep_this")
    val epThis: String,
    @SerialName("event_points")
    val eventPoints: Int,
    @SerialName("first_name")
    val firstName: String?,
    @SerialName("form")
    val form: String,
    @SerialName("id")
    val id: Int,
    @SerialName("in_dreamteam")
    val inDreamTeam: Boolean,
    @SerialName("news")
    val news: String,
    @SerialName("news_added")
    val newsAdded: String?,
    @SerialName("now_cost")
    val nowCost: Int,
    @SerialName("photo")
    val photo: String?,
    @SerialName("points_per_game")
    val pointsPerGame: String,
    @SerialName("removed")
    val removed: Boolean,
    @SerialName("second_name")
    val secondName: String?,
    @SerialName("selected_by_percent")
    val selectedByPercent: String,
    @SerialName("special")
    val special: Boolean,
    @SerialName("squad_number")
    val squadNumber: Int?,
    @SerialName("status")
    val status: String,
    @SerialName("team")
    val team: Int,
    @SerialName("team_code")
    val teamCode: Int,
    @SerialName("total_points")
    val totalPoints: Int,
    @SerialName("transfers_in")
    val transfersIn: Long,
    @SerialName("transfers_in_event")
    val transfersInEvent: Long,
    @SerialName("transfers_out")
    val transfersOut: Long,
    @SerialName("transfers_out_event")
    val transfersOutEvent: Long,
    @SerialName("value_form")
    val valueForm: String,
    @SerialName("value_season")
    val valueSeason: String,
    @SerialName("web_name")
    val webName: String,
    @SerialName("region")
    val region: Int?,
    @SerialName("team_join_date")
    val teamJoinDate: String?,
    @SerialName("birth_date")
    val birthdate: String?,
    @SerialName("has_temporary_code")
    val hasTemporaryCode: Boolean,
    @SerialName("opta_code")
    val optaCode: String,
    @SerialName("minutes")
    val minutes: Long,
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
    val clearancesBlocksInterceptions: Int,
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
    @SerialName("influence_rank")
    val influenceRank: Int,
    @SerialName("influence_rank_type")
    val influenceRankType: Int,
    @SerialName("creativity_rank")
    val creativityRank: Int,
    @SerialName("creativity_rank_type")
    val creativityRankType: Int,
    @SerialName("threat_rank")
    val threatRank: Int,
    @SerialName("threat_rank_type")
    val threatRankType: Int,
    @SerialName("ict_index_rank")
    val ictIndexRank: Int,
    @SerialName("ict_index_rank_type")
    val ictIndexRankType: Int,
    @SerialName("corners_and_indirect_freekicks_order")
    val cornersAndIndirectFreeKicksOrder: Int?,
    @SerialName("corners_and_indirect_freekicks_text")
    val cornersAndIndirectFreeKicksText: String?,
    @SerialName("direct_freekicks_order")
    val directFreeKicksOrder: Int?,
    @SerialName("direct_freekicks_text")
    val directFreeKicksText: String?,
    @SerialName("penalties_order")
    val penaltiesOrder: Int?,
    @SerialName("penalties_text")
    val penaltiesText: String?,
    @SerialName("expected_goals_per_90")
    val expectedGoalsPer90: Float,
    @SerialName("saves_per_90")
    val savesPer90: Float,
    @SerialName("expected_assists_per_90")
    val expectedAssistsPer90: Float,
    @SerialName("expected_goal_involvements_per_90")
    val expectedGoalInvolvementsPer90: Float,
    @SerialName("expected_goals_conceded_per_90")
    val expectedGoalsConcededPer90: Float,
    @SerialName("goals_conceded_per_90")
    val goalsConcededPer90: Float,
    @SerialName("now_cost_rank")
    val nowCostRank: Int,
    @SerialName("now_cost_rank_type")
    val nowCostRankType: Int,
    @SerialName("form_rank")
    val formRank: Int,
    @SerialName("form_rank_type")
    val formRankType: Int,
    @SerialName("points_per_game_rank")
    val pointsPerGameRank: Int,
    @SerialName("points_per_game_rank_type")
    val pointsPerGameRankType: Int,
    @SerialName("selected_rank")
    val selectedRank: Int,
    @SerialName("selected_rank_type")
    val selectedRankType: Int,
    @SerialName("starts_per_90")
    val startsPer90: Float,
    @SerialName("clean_sheets_per_90")
    val cleanSheetsPer90: Float,
    @SerialName("defensive_contribution_per_90")
    val defensiveContributionsPer90: Float
)
