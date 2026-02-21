package io.github.rubenquadros.gameweekscout.server.fpl.model.fixture

import ai.koog.agents.core.tools.annotations.LLMDescription
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@LLMDescription("A specific statistical category (e.g., goals) and the players responsible for them in a fixture.")
data class FixtureStat(
    @SerialName("identifier")
    @property:LLMDescription("The type of statistic (e.g., 'goals_scored', 'yellow_cards', 'bonus').")
    val identifier: String,
    @SerialName("a")
    @property:LLMDescription("List of away team players contributing to this stat.")
    val away: List<Stat>,
    @SerialName("h")
    @property:LLMDescription("List of home team players contributing to this stat.")
    val home: List<Stat>
)

@Serializable
@LLMDescription("An individual contribution to a match statistic.")
data class Stat(
    @SerialName("value")
    @property:LLMDescription("The value of the stat (e.g., number of goals or BPS points).")
    val value: Int,
    @SerialName("element")
    @property:LLMDescription("The internal player ID (element ID) responsible.")
    val element: Int
)