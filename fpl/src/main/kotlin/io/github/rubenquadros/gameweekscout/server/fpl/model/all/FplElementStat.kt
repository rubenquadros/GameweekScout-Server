package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import ai.koog.agents.core.tools.annotations.LLMDescription
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@LLMDescription("A metadata definition for a player performance metric, mapping the internal data name to a readable label.")
data class FplElementStat(
    @SerialName("label")
    @property:LLMDescription("The human-readable label for the stat (e.g., 'Goals Scored').")
    val label: String,
    @SerialName("name")
    @property:LLMDescription("The internal key name used in player data objects (e.g., 'goals_scored').")
    val name: String
)
