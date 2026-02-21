package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import ai.koog.agents.core.tools.annotations.LLMDescription
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplChip(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("number")
    val number: Int,
    @SerialName("start_event")
    val startEvent: Int,
    @SerialName("stop_event")
    val stopEvent: Int,
    @SerialName("chip_type")
    val chipType: String
)

@Serializable
@LLMDescription("A statistical summary of how many managers activated a specific bonus chip during a gameweek.")
data class FplChipPlayed(
    @SerialName("chip_name")
    @property:LLMDescription("The unique identifier of the chip used (e.g., 'bboost' for Bench Boost, '3xc' for Triple Captain, 'wildcard').")
    val chipName: String,
    @SerialName("num_played")
    @property:LLMDescription("The total count of FPL managers who chose to play this specific chip in this gameweek.")
    val numPlayed: Long
)