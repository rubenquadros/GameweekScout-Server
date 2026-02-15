package io.github.rubenquadros.gameweekscout.server.ai.persistence

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val updatedAt: String,
    val data: String
)
