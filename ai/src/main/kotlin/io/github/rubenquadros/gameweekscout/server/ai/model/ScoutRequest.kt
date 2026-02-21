package io.github.rubenquadros.gameweekscout.server.ai.model

import kotlinx.serialization.Serializable

@Serializable
data class Content(
    val query: String
)