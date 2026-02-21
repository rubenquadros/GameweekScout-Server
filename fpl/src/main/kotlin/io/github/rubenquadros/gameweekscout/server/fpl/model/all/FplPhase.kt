package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import ai.koog.agents.core.tools.annotations.LLMDescription
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@LLMDescription("A time-based division of the season (e.g., a specific month or the 'Overall' season) used for tracking partial-season rankings and awards.")
data class FplPhase(
    @SerialName("id")
    @property:LLMDescription("The unique identifier for the phase.")
    val id: Int,
    @SerialName("name")
    @property:LLMDescription("The name of the phase, such as 'Overall', 'August', or 'December'.")
    val name: String,
    @SerialName("start_event")
    @property:LLMDescription("The Gameweek ID that marks the beginning of this phase.")
    val startEvent: Int,
    @SerialName("stop_event")
    @property:LLMDescription("The Gameweek ID that marks the end of this phase.")
    val stopEvent: Int,
    @SerialName("highest_score")
    @property:LLMDescription("The highest score achieved by any manager globally within this specific phase. Null if the phase has not started.")
    val highestScore: Int?
)
