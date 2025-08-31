package io.github.rubenquadros.gameweekscout.server.fpl.model.all

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
data class FplChipPlayed(
    @SerialName("chip_name")
    val chipName: String,
    @SerialName("num_played")
    val numPlayed: Long
)