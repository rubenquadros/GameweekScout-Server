package io.github.rubenquadros.gameweekscout.server.ai.instruction.functions

import io.github.rubenquadros.gameweekscout.server.ai.model.FunctionDeclaration
import io.github.rubenquadros.gameweekscout.server.ai.model.Property
import io.github.rubenquadros.gameweekscout.server.ai.model.Schema
import kotlinx.serialization.json.JsonObjectBuilder
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject

internal val allTeamsFunction = FunctionDeclaration(
    name = allTeamsName,
    description = """
        Get the data of all the teams present in the Premier League.
    """.trimIndent(),
    parameters = Schema(
        type = "object"
    ),
    //response = getAllTeamsResponse()
)

internal val teamFunction = FunctionDeclaration(
    name = teamName,
    description = """
        Get the data of a specific team present in the Premier League.
    """.trimIndent(),
    parameters = Schema(
        type = "object",
        properties = mapOf(
            "id" to Property(
                type = "integer",
                description = "The unique id of the team"
            )
        ),
        required = listOf("id")
    ),
    //response = getTeamResponse()
)

internal const val allTeamsName = "get_all_teams"
internal const val teamName = "get_team"

private fun getAllTeamsResponse() = buildJsonObject {
    put("type", "array")
    putJsonObject("items") {
        put("type", "object")
        putJsonObject("properties") {
            getTeam()
        }
    }
}

private fun getTeamResponse() = buildJsonObject {
    put("type", "object")
    putJsonObject("properties") {
        getTeam()
    }
}

private fun JsonObjectBuilder.getTeam() {
    put("id", buildJsonObject {
        put("type", "integer")
        put("description", "The unique id of this team")
    })
    put("name", buildJsonObject {
        put("type", "string")
        put("description", "The name of this team")
    })
    put("form", buildJsonObject {
        put("type", "string")
        put("description", "The form rating of this team")
        put("nullable", true)
    })
    put("strength", buildJsonObject {
        put("type", "integer")
        put("description", "The strength of this team. The values range from 1 to 5 with 5 being the max")
    })
    put("strengthOverallHome", buildJsonObject {
        put("type", "integer")
        put("description", "The overall home games strength of this team")
    })
    put("strengthOverallAway", buildJsonObject {
        put("type", "integer")
        put("description", "The overall away games strength of this team")
    })
    put("strengthAttackHome", buildJsonObject {
        put("type", "integer")
        put("description", "The overall home games attacking strength of this team")
    })
    put("strengthAttackAway", buildJsonObject {
        put("type", "integer")
        put("description", "The overall away games attacking strength of this team")
    })
    put("strengthDefenceHome", buildJsonObject {
        put("type", "integer")
        put("description", "The overall home games defensive strength of this team")
    })
    put("strengthDefenceAway", buildJsonObject {
        put("type", "integer")
        put("description", "The overall away games defensive strength of this team")
    })
}