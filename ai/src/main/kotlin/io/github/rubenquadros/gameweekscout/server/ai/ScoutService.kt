package io.github.rubenquadros.gameweekscout.server.ai

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.agent.context.RollbackStrategy
import ai.koog.agents.core.dsl.builder.forwardTo
import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.extension.nodeAppendPrompt
import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.agents.core.tools.reflect.tools
import ai.koog.agents.ext.agent.subgraphWithTask
import ai.koog.agents.features.eventHandler.feature.handleEvents
import ai.koog.agents.snapshot.feature.Persistence
import ai.koog.prompt.executor.clients.google.GoogleModels
import ai.koog.prompt.executor.llms.all.simpleGoogleAIExecutor
import io.github.rubenquadros.gameweekscout.server.ai.model.InputProcessResponse
import io.github.rubenquadros.gameweekscout.server.ai.model.getGeminiConfig
import io.github.rubenquadros.gameweekscout.server.ai.persistence.FirestorePersistenceProvider
import io.github.rubenquadros.gameweekscout.server.fpl.FplApi

interface ScoutService {
    suspend fun getScoutAdvice(input: String, userId: String): String?
}

internal class ScoutServiceImpl(
    private val fplApi: FplApi,
    private val persistence: FirestorePersistenceProvider,
) : ScoutService {

    private val fplToolsRegistry = ToolRegistry {
        tools(fplApi)
    }

    private val scoutStrategy = strategy<String, String>("fpl-scout") {
        val inputProcessingPrompt by nodeAppendPrompt<String>("input-process-prompt") {
            system(inputProcessInstruction)
        }

        val processInput by subgraphWithTask<String, InputProcessResponse>(
            name = "input-processor",
            llmModel = GoogleModels.Gemini2_5FlashLite,
            assistantResponseRepeatMax = 1
        ) { input ->
            """
                User query: "$input"
            """.trimIndent()
        }

        val scoutAdvicePrompt by nodeAppendPrompt<InputProcessResponse>("scout-advice-prompt") {
            system(scoutAdviceInstruction)
        }

        val provideSuggestion by subgraphWithTask<InputProcessResponse, String>(
            name = "scout-advisor",
            llmModel = GoogleModels.Gemini2_5Flash,
            tools = fplToolsRegistry.tools,
            assistantResponseRepeatMax = 5
        ) { context ->
            """
                User query: "${context.originalInput}"
            """.trimIndent()
        }

        edge(nodeStart forwardTo inputProcessingPrompt)
        edge(inputProcessingPrompt forwardTo processInput)
        edge(processInput forwardTo nodeFinish onCondition { !it.shouldProceed } transformed { it.response })
        edge(processInput forwardTo scoutAdvicePrompt onCondition { it.shouldProceed })
        edge(scoutAdvicePrompt forwardTo provideSuggestion)
        edge(provideSuggestion forwardTo nodeFinish)
    }

    private val geminiConfig = getGeminiConfig()

    override suspend fun getScoutAdvice(input: String, userId: String): String? {
        val result = runCatching {
            val agent = AIAgent(
                id = userId,
                strategy = scoutStrategy,
                promptExecutor = simpleGoogleAIExecutor(apiKey = geminiConfig.apiKey),
                llmModel = GoogleModels.Gemini2_5Flash,
                toolRegistry = fplToolsRegistry
            ) {
                install(Persistence) {
                    storage = persistence
                    enableAutomaticPersistence = true
                    rollbackStrategy = RollbackStrategy.MessageHistoryOnly
                }

                handleEvents { eventHandler() }
            }

            agent.run(input)

        }.getOrNull()

        if (result != null) {
            persistence.saveAgentResponse(userId, result)
        }

        return result
    }
}