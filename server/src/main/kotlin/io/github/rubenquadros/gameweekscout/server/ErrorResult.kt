package io.github.rubenquadros.gameweekscout.server

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResult(
    val message: String
)
