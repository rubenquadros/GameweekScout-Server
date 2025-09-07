package io.github.rubenquadros.gameweekscout.server.ai.model

import kotlinx.serialization.Serializable

@Serializable
data class ScoutResponse(
    val candidates: List<Candidate>,
    val usageMetaData: UsageMetaData?,
    val modelVersion: String?
)

@Serializable
data class Candidate(
    val content: Content,
    val finishReason: String,
    val avgLogprobs: Double? = null
)

@Serializable
data class UsageMetaData(
    val promptTokenCount: Int,
    val candidatesTokenCount: Int,
    val totalTokenCount: Int,
    val promptTokensDetails: List<TokensDetail>,
    val candidatesTokensDetails: List<TokensDetail>
)

@Serializable
data class TokensDetail(
    val modality: String,
    val tokenCount: Int
)