package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplGameConfig(
    @SerialName("settings")
    val settings: FplSettings,
    @SerialName("rules")
    val rules: FplGameSettings,
    @SerialName("scoring")
    val scoring: FplScoring
)