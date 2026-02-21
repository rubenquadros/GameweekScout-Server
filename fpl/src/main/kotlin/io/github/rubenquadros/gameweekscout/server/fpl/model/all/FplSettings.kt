package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import ai.koog.agents.core.tools.annotations.LLMDescription
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@LLMDescription("General environment settings for the game.")
data class FplSettings(
    @SerialName("entry_per_event")
    @property:LLMDescription("Boolean indicating if entries are restricted per gameweek event.")
    val entryPerEvent: Boolean,
    @SerialName("timezone")
    @property:LLMDescription("The global timezone used for game deadlines (usually UTC).")
    val timezone: String?,
    @SerialName("club_badge_creation_enabled")
    val clubBadgeCreationEnabled: Boolean?
)
