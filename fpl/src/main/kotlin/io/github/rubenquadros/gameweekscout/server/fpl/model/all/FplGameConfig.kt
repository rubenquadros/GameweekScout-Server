package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import ai.koog.agents.core.tools.annotations.LLMDescription
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@LLMDescription("A structured configuration object containing the settings, rules, and point-scoring logic for the FPL game.")
data class FplGameConfig(
    @SerialName("settings")
    @property:LLMDescription("General operational settings like timezones.")
    val settings: FplSettings?,
    @SerialName("rules")
    @property:LLMDescription("Technical rules for squad building, transfers, and league management.")
    val rules: FplGameSettings?,
    @SerialName("scoring")
    @property:LLMDescription("The definitive scoring matrix defining how many points are awarded for specific actions (goals, assists, etc.) based on player position.")
    val scoring: FplScoring?
)