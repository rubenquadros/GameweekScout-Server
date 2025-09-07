package io.github.rubenquadros.gameweekscout.server.ai.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class ScoutRequest(
    @SerialName("system_instruction")
    val systemInstruction: SystemInstruction,
    val generationConfig: GenerationConfig = GenerationConfig(),
    val contents: List<Content>,
    val tools: List<SystemTool>
)

@Serializable
data class GenerationConfig(
    val temperature: Float = 1f
)

@Serializable
data class Content(
    val role: String,
    val parts: List<Part>
)

@Serializable
data class Part(
    val text: String? = null,
    val functionCall: FunctionCall? = null,
    val functionResponse: FunctionResponse? = null
)

@Serializable
data class FunctionCall(
    val name: String,
    val args: JsonObject
)

@Serializable
data class FunctionResponse(
    val name: String,
    val response: JsonObject
)

@Serializable
data class SystemInstruction(
    val parts: List<Part>
)

@Serializable
data class SystemTool(
    val functionDeclarations: List<FunctionDeclaration>
)

@Serializable
data class FunctionDeclaration(
    val name: String,
    val description: String,
    val parameters: Schema,
    val response: JsonObject? = null,
)

@Serializable
data class Schema(
    val type: String,
    val properties: Map<String, Property> = emptyMap(),
    val required: List<String> = emptyList()
)

@Serializable
data class Property(
    val type: String,
    val description: String
)