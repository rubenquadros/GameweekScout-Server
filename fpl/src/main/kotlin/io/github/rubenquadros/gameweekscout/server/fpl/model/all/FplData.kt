package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplData(
    @SerialName("total_players")
    val totalPlayers: Long,
    @SerialName("chips")
    val chips: List<FplChip>,
    @SerialName("events")
    val events: List<FplEvent>,
    @SerialName("game_settings")
    val gameSettings: FplGameSettings,
    @SerialName("game_config")
    val gameConfig: FplGameConfig,
    @SerialName("phases")
    val phases: List<FplPhase>,
    @SerialName("teams")
    val teams: List<FplTeam>,
    @SerialName("element_stats")
    val elementStats: List<FplElementStat>,
    @SerialName("element_types")
    val elementTypes: List<FplElementType>,
    @SerialName("elements")
    val elements: List<FplElement>
)
