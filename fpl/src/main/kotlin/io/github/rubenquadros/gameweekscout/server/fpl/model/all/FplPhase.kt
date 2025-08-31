package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplPhase(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("start_event")
    val startEvent: Int,
    @SerialName("stop_event")
    val stopEvent: Int,
    @SerialName("highest_score")
    val highestScore: Int?
)
