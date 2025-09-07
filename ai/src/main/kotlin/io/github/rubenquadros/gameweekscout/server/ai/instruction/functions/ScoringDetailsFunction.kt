package io.github.rubenquadros.gameweekscout.server.ai.instruction.functions

import io.github.rubenquadros.gameweekscout.server.ai.model.FunctionDeclaration
import io.github.rubenquadros.gameweekscout.server.ai.model.Schema
import kotlinx.serialization.json.JsonObjectBuilder
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject

val scoringDetailsFunction = FunctionDeclaration(
    name = scoringDetailsName,
    description = """
        Gives details about how points are scored by players in the Fantasy Premier League.
    """.trimIndent(),
    parameters = Schema(
        type = "object"
    ),
    //response = getScoringDetailsResponse()
)

internal const val scoringDetailsName = "get_scoring_details"

private fun getScoringDetailsResponse() = buildJsonObject {
    put("type", "object")
    putJsonObject("properties") {
        put("longPlay", buildJsonObject {
            put("type", "integer")
            put("description", """
                If they player has played 60 or more minutes excluding the stoppage time in a game, then they get 2 points as longPlay.
                The player will either get longPlay or shortPlay points not both.
            """.trimIndent())
        })
        put("shortPlay", buildJsonObject {
            put("type", "integer")
            put("description", """
                If they player has played up to 60 minutes excluding the stoppage time in a game, then they get 1 point as shortPlay.
                The player will either get longPlay or shortPlay points not both.
            """.trimIndent())
        })
        put("goalsConceded", buildJsonObject {
            put("type", "object")
            put("description", "Points earned by a goalkeeper or defender for every 2 goals conceded. This will be either 0 or a negative value")
            putJsonObject("properties") {
                getPayerScoring()
            }
        })
        put("saves", buildJsonObject {
            put("type", "integer")
            put("description", "Points earned by a goalkeeper for shots saved. Every 3 shots saved gets 1 point")
        })
        put("goalsScored", buildJsonObject {
            put("type", "object")
            put("description", "Points earned by each player for every goal scored.")
            putJsonObject("properties") {
                getPayerScoring()
            }
        })
        put("assists", buildJsonObject {
            put("type", "integer")
            put("description", "Points earned by a player per assist")
        })
        put("cleanSheets", buildJsonObject {
            put("type", "object")
            put("description", "Points earned by each player for a keeping a clean sheet")
            putJsonObject("properties") {
                getPayerScoring()
            }
        })
        put("penaltiesSaved", buildJsonObject {
            put("type", "integer")
            put("description", "Points earned by a goalkeeper per penalty save")
        })
        put("penaltiesMissed", buildJsonObject {
            put("type", "integer")
            put("description", "Points earned by a player per each missing penalty")
        })
        put("yellowCards", buildJsonObject {
            put("type", "integer")
            put("description", "Points earned by a player for a yellow card. This will be either 0 or a negative value")
        })
        put("redCards", buildJsonObject {
            put("type", "integer")
            put("description", "Points earned by a player for a red card. This will be either 0 or a negative value")
        })
        put("ownGoals", buildJsonObject {
            put("type", "integer")
            put("description", "Points earned by a player for every own goal. This will be either 0 or a negative value")
        })
        put("bonus", buildJsonObject {
            put("type", "integer")
            put("description", "Bonus points earned for best players in a match. This value will range from 1-3")
        })
        put("defensiveContributions", buildJsonObject {
            put("type", "object")
            put("description", "Points earned by each player for defensive contributions")
            putJsonObject("properties") {
                getPayerScoring()
            }
        })
    }
}

private fun JsonObjectBuilder.getPayerScoring() {
    put("DEF", buildJsonObject {
        put("type", "integer")
        put("description", "Points earned by a player for this stat in the game")
    })
    put("FWD", buildJsonObject {
        put("type", "integer")
        put("description", "Points earned by a player for this stat in the game")
    })
    put("GKP", buildJsonObject {
        put("type", "integer")
        put("description", "Points earned by a player for this stat in the game")
    })
    put("MID", buildJsonObject {
        put("type", "integer")
        put("description", "Points earned by a player for this stat in the game")
    })
}