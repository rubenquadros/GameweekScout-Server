package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import ai.koog.agents.core.tools.annotations.LLMDescription
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@LLMDescription("The root data structure for the FPL game state, containing all players, teams, and gameweek schedules.")
data class FplData(
    @SerialName("total_players")
    @property:LLMDescription("The total count of all registered FPL managers worldwide.")
    val totalPlayers: Long,
    @SerialName("chips")
    @property:LLMDescription("A list of special game chips (e.g., Wildcard, Triple Captain, Bench Boost, Free Hit) available to managers.")
    val chips: List<FplChip>,
    @SerialName("events")
    @property:LLMDescription("A list of all 38 Gameweeks in the season, including deadlines and scoring summaries.")
    val events: List<FplEvent>,
    @SerialName("game_settings")
    @property:LLMDescription("Global game settings including point rules, transfer limits, and chip availability.")
    val gameSettings: FplGameSettings,
    @SerialName("game_config")
    val gameConfig: FplGameConfig,
    @SerialName("phases")
    @property:LLMDescription("Monthly or seasonal time periods used for ranking phases.")
    val phases: List<FplPhase>,
    @SerialName("teams")
    @property:LLMDescription("The 20 Premier League clubs currently in the competition.")
    val teams: List<FplTeam>,
    @SerialName("element_stats")
    @property:LLMDescription("Definitions of the statistics tracked for players (e.g., Goals, Assists).")
    val elementStats: List<FplElementStat>,
    @SerialName("element_types")
    @property:LLMDescription("Definitions for player positions (GKP, DEF, MID, FWD).")
    val elementTypes: List<FplElementType>,
    @SerialName("elements")
    @property:LLMDescription("The complete database of every football player in the game with their current stats.")
    val elements: List<FplElement>
)
