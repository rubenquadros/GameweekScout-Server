package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplSettings(
    @SerialName("entry_per_event")
    val entryPerEvent: Boolean,
    @SerialName("timezone")
    val timezone: String?,
    @SerialName("club_badge_creation_enabled")
    val clubBadgeCreationEnabled: Boolean
)
