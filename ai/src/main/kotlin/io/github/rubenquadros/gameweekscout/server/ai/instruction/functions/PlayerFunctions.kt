package io.github.rubenquadros.gameweekscout.server.ai.instruction.functions

import io.github.rubenquadros.gameweekscout.server.ai.model.FunctionDeclaration
import io.github.rubenquadros.gameweekscout.server.ai.model.Property
import io.github.rubenquadros.gameweekscout.server.ai.model.Schema
import kotlinx.serialization.json.JsonObjectBuilder
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject

val allPlayersFunction = FunctionDeclaration(
    name = allPlayersName,
    description = """
        Get the Fantasy Premier League data of all the players.
    """.trimIndent(),
    parameters = Schema(
        type = "object"
    ),
    //response = getAllPlayersResponse()
)

val playerFunction = FunctionDeclaration(
    name = playerName,
    description = """
        Get the Fantasy Premier League data of a specific player.
    """.trimIndent(),
    parameters = Schema(
        type = "object",
        properties = mapOf(
            "id" to Property(
                type = "integer",
                description = "The unique id of the player"
            )
        ),
        required = listOf("id")
    ),
    //response = getPlayerResponse()
)

internal const val allPlayersName = "get_all_players"
internal const val playerName = "get_player"

private fun getAllPlayersResponse() = buildJsonObject {
    put("type", "array")
    putJsonObject("items") {
        put("type", "object")
        putJsonObject("properties") {
            getPlayer()
        }
    }
}

private fun getPlayerResponse() = buildJsonObject {
    put("type", "object")
    putJsonObject("properties") {
        getPlayer()
    }
}

private fun JsonObjectBuilder.getPlayer() {
    put("id", buildJsonObject {
        put("type", "integer")
        put("description", "The unique id of the player")
    })
    put("firstName", buildJsonObject {
        put("type", "string")
        put("description", "The first name of the player")
        put("nullable", true)
    })
    put("secondName", buildJsonObject {
        put("type", "string")
        put("description", "The second name of the player")
        put("nullable", true)
    })
    put("team", buildJsonObject {
        put("type", "integer")
        put("description", "The unique id of the team of the player")
    })
    put("elementType", buildJsonObject {
        put("type", "integer")
        put("description", """
            There can be 4 different values ranging from 1 to 4.
            Definition of each of the values is as follows:
            1 - Goalkeeper. Short name: GKP
            2 - Defender. Short name: DEF
            3 - Midfielder. Short name: MID
            4 - Forward. Short name: FWD
        """.trimIndent())
    })
    put("chanceOfPlayingThisRound", buildJsonObject {
        put("type", "integer")
        put("description", "The chances of a player being able to play in this game week. 0 would mean there is no chance. Ignore null values and treat is as player is eligible to play")
        put("nullable", true)
    })
    put("chanceOfPlayingNextRound", buildJsonObject {
        put("type", "integer")
        put("description", "The chances of a player being able to play in the next game week. 0 would mean there is no chance. Ignore null values and treat is as player is eligible to play")
        put("nullable", true)
    })
    put("epNext", buildJsonObject {
        put("type", "string")
        put("description", "Expected points return in the next game week")
    })
    put("epThis", buildJsonObject {
        put("type", "string")
        put("description", "Expected points return in the current game week")
    })
    put("eventPoints", buildJsonObject {
        put("type", "string")
        put("description", "The points returned in the previous game week")
    })
    put("form", buildJsonObject {
        put("type", "string")
        put("description", "The current form of the player")
    })
    put("nowCost", buildJsonObject {
        put("type", "integer")
        put("description", "The current cost of the player. This has to be divided by 10 to get the actual cost.")
    })
    put("pointsPerGame", buildJsonObject {
        put("type", "string")
        put("description", "The average points returned by the player per game")
    })
    put("selectedByPercent", buildJsonObject {
        put("type", "string")
        put("description", "The percentage of Fantasy Premier League managers who have this player in their team")
    })
    put("totalPoints", buildJsonObject {
        put("type", "integer")
        put("description", "The total points scored by the player so far")
    })
    put("minutes", buildJsonObject {
        put("type", "integer")
        put("description", "Minutes played by the player so far")
    })
    put("goalsScored", buildJsonObject {
        put("type", "integer")
        put("description", "Goals scored by the player so far")
    })
    put("assists", buildJsonObject {
        put("type", "integer")
        put("description", "Assists by the player so far")
    })
    put("cleanSheets", buildJsonObject {
        put("type", "integer")
        put("description", "Clean sheets by the player so far")
    })
    put("goalsConceded", buildJsonObject {
        put("type", "integer")
        put("description", "Goals conceded by the player so far")
    })
    put("ownGoals", buildJsonObject {
        put("type", "integer")
        put("description", "Own goals scored by the player so far")
    })
    put("penaltiesSaved", buildJsonObject {
        put("type", "integer")
        put("description", "Penalties saved by the player so far")
    })
    put("penaltiesMissed", buildJsonObject {
        put("type", "integer")
        put("description", "Penalties missed by the player so far")
    })
    put("saves", buildJsonObject {
        put("type", "integer")
        put("description", "The number of saves made by the player so far")
    })
    put("yellowCards", buildJsonObject {
        put("type", "integer")
        put("description", "Number of times the player has been yellow carded so far")
    })
    put("redCards", buildJsonObject {
        put("type", "integer")
        put("description", "Number of times the player has been red carded so far")
    })
    put("bonus", buildJsonObject {
        put("type", "integer")
        put("description", "Total bonus points scored by the player")
    })
    put("influence", buildJsonObject {
        put("type", "string")
        put("description", "The influence of the player. Higher the better")
    })
    put("creativity", buildJsonObject {
        put("type", "string")
        put("description", "The creativity of the player. Higher the better")
    })
    put("threat", buildJsonObject {
        put("type", "string")
        put("description", "The threat of the player. Higher the better")
    })
    put("clearancesBlocksInterceptions", buildJsonObject {
        put("type", "integer")
        put("description", "Total number of clearances or blocks or interceptions made by the player")
    })
    put("recoveries", buildJsonObject {
        put("type", "integer")
        put("description", "Total number of recoveries made by the player")
    })
    put("tackles", buildJsonObject {
        put("type", "integer")
        put("description", "Total number of tackles made by the player")
    })
    put("starts", buildJsonObject {
        put("type", "integer")
        put("description", "Total number of game starts made by the player")
    })
    put("defensiveContribution", buildJsonObject {
        put("type", "integer")
        put("description", "Total number of defensive contributions made by the player")
    })
}