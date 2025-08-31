package io.github.rubenquadros.gameweekscout.server.fpl.model.player

import io.github.rubenquadros.gameweekscout.server.fpl.model.fixture.FplFixture
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplPlayer(
    @SerialName("fixtures")
    val fixtures: List<FplFixture>,
    @SerialName("history")
    val history: List<FplHistory>,
    @SerialName("history_past")
    val historyPast: List<FplHistoryPast>
)
