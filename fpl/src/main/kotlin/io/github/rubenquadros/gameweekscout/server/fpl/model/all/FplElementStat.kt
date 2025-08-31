package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplElementStat(
    @SerialName("label")
    val label: String,
    @SerialName("name")
    val name: String
)
