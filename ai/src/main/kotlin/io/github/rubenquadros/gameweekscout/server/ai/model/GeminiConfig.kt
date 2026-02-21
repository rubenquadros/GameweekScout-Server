package io.github.rubenquadros.gameweekscout.server.ai.model

import ai.koog.prompt.executor.clients.google.GoogleModels
import ai.koog.prompt.llm.LLModel
import java.io.File
import java.util.Properties

internal data class GeminiConfig(
    val apiKey: String,
    val model: Model
) {
    fun getLLMModel(model: String): LLModel {
        return when (model) {
            "gemini-2.5-flash" -> GoogleModels.Gemini2_5Flash
            "gemini-2.5-flash-lite" -> GoogleModels.Gemini2_5FlashLite
            "gemini-2.0-flash" -> GoogleModels.Gemini2_0Flash
            "gemini-2.0-flash-lite" -> GoogleModels.Gemini2_0FlashLite
            else -> GoogleModels.Gemini2_5Flash //default
        }
    }
}

internal fun getGeminiConfig(): GeminiConfig {
    return runCatching {
        val properties = Properties().apply {
            File("/Users/rquadros/Documents/Ruben/git_tree/GameWeekScout-Server/local.properties")
                .inputStream()
                .use { load(it) }
        }

        return GeminiConfig(
            apiKey = properties.getProperty("geminiApiKey"),
            model = Model(
                inputProcess = properties.getProperty("inputProcessModel"),
                retrieval = properties.getProperty("retrievalModel"),
                suggestion = properties.getProperty("suggestionModel"),
                default = properties.getProperty("defaultModel")
            ),
        )
    }.getOrElse {
        GeminiConfig(
            apiKey = System.getenv("GEMINI_API_KEY"),
            model = Model(
                inputProcess = System.getenv("INPUT_PROCESS_MODEL"),
                retrieval = System.getenv("RETRIEVAL_MODEL"),
                suggestion = System.getenv("SUGGESTION_MODEL"),
                default = System.getenv("DEFAULT_MODEL")
            )
        )
    }
}

internal data class Model(
    val default: String,
    val inputProcess: String,
    val retrieval: String,
    val suggestion: String
)