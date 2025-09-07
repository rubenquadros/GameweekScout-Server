package io.github.rubenquadros.gameweekscout.server.ai

import io.github.rubenquadros.gameweekscout.server.ai.instruction.fplTool
import io.github.rubenquadros.gameweekscout.server.ai.instruction.functions.*
import io.github.rubenquadros.gameweekscout.server.ai.instruction.scoutInstruction
import io.github.rubenquadros.gameweekscout.server.ai.model.*
import io.github.rubenquadros.gameweekscout.server.ai.model.fpl.toFixtureEntity
import io.github.rubenquadros.gameweekscout.server.ai.model.fpl.toPlayerEntity
import io.github.rubenquadros.gameweekscout.server.ai.model.fpl.toScoreEntity
import io.github.rubenquadros.gameweekscout.server.ai.model.fpl.toTeamEntity
import io.github.rubenquadros.gameweekscout.server.fpl.FplApi
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.*

interface ScoutService {
    suspend fun getScoutAdvice(contents: List<Content>): ScoutResponse?
}

internal class ScoutServiceImpl(
    private val httpClient: HttpClient,
    private val fplApi: FplApi
) : ScoutService {

    private val geminiConfig = getGeminiConfig()
    private val conversationHistory: MutableList<Content> = mutableListOf()
    private var scoutResponse: ScoutResponse? = null

    override suspend fun getScoutAdvice(contents: List<Content>): ScoutResponse? {
        val maxLoops = 5
        var currentLoop = 0

        conversationHistory.apply {
            clear()
            addAll(contents)
        }

        while (currentLoop < maxLoops) {
            currentLoop++

            scoutResponse = askScout(conversationHistory)

            val functionCalls = getFunctionCallOrNull(scoutResponse!!)

            if (functionCalls.isNullOrEmpty()) break

            //add model response
            conversationHistory.add(
                Content(role = "model", parts = scoutResponse?.candidates?.firstOrNull()?.content?.parts ?: emptyList())
            )

            //execute function calls
            val toolResponses = functionCalls.map { functionCall ->
                println("Calling function: ${functionCall.name}")
                println("Function args: ${functionCall.args.values}")

                val functionResponse = FunctionResponse(
                    name = functionCall.name,
                    response = executeFunctionCall(functionCall)
                )

                Content(role = "tool", parts = listOf(Part(functionResponse = functionResponse)))
            }

            //add to conversation for new call
            conversationHistory.addAll(toolResponses)
        }

        return scoutResponse
    }

    private suspend fun askScout(contents: List<Content>): ScoutResponse {
        return httpClient.post {
            val apiRequest = ScoutRequest(
                systemInstruction = scoutInstruction,
                tools = listOf(fplTool),
                contents = contents
            )

            url {
                appendPathSegments("/${geminiConfig.model}:generateContent")
                parameters.append("key", geminiConfig.apiKey)
            }

            setBody(apiRequest)

        }.body<ScoutResponse>()
    }

    private fun getFunctionCallOrNull(scoutResponse: ScoutResponse): List<FunctionCall>? {
        return scoutResponse.candidates.firstOrNull()?.content?.parts?.mapNotNull { it.functionCall }?.distinctBy { it.name }
    }

    private suspend fun executeFunctionCall(functionCall: FunctionCall): JsonObject {
        val functionCallResponse = when (functionCall.name) {
            fixturesName -> {
                convertToJsonObject(functionResponse = fplApi.getAllFixtures().map { it.toFixtureEntity() })
            }

            upcomingFixturesName -> {
                convertToJsonObject(functionResponse = fplApi.getUpcomingFixtures().map { it.toFixtureEntity() })
            }

            allTeamsName -> {
                convertToJsonObject(functionResponse = fplApi.getAllTeams().map { it.toTeamEntity() })
            }

            teamName -> {
                convertToJsonObject(
                    functionResponse = fplApi.getTeam(id = extractId(functionCall.args))?.toTeamEntity()
                )
            }

            allPlayersName -> {
                convertToJsonObject(functionResponse = fplApi.getAllPlayers().map { it.toPlayerEntity() })
            }

            playerName -> {
                convertToJsonObject(
                    functionResponse = fplApi.getPlayer(id = extractId(functionCall.args))
                )
            }

            scoringDetailsName -> {
                convertToJsonObject(functionResponse = fplApi.getScoringData()?.toScoreEntity())
            }

            else -> {
                error("Unknown function name: ${functionCall.name}")
            }
        }

        return convertToJsonObject(functionCallResponse)
    }

    private fun extractId(args: JsonObject): Int {
        val id = args["id"] ?: error("Cannot get team name without id")

        return id.jsonPrimitive.int
    }

    private inline fun <reified T>convertToJsonObject(functionResponse: T): JsonObject {
        return buildJsonObject {
            put("response", Json.encodeToJsonElement(functionResponse))
        }
    }
}