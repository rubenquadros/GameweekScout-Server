package io.github.rubenquadros.gameweekscout.server.fpl.model.fixture

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FixtureStat(
    @SerialName("identifier")
    val identifier: String,
    @SerialName("a")
    val away: List<Stat>,
    @SerialName("h")
    val home: List<Stat>
)

@Serializable
data class Stat(
    @SerialName("value")
    val value: Int,
    @SerialName("element")
    val element: Int
)