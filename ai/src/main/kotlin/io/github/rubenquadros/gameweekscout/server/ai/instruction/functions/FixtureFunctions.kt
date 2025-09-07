package io.github.rubenquadros.gameweekscout.server.ai.instruction.functions

import io.github.rubenquadros.gameweekscout.server.ai.model.FunctionDeclaration
import io.github.rubenquadros.gameweekscout.server.ai.model.Schema
import kotlinx.serialization.json.JsonObjectBuilder
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject

internal val allFixturesFunction = FunctionDeclaration(
    name = fixturesName,
    description = """
        Gets the entire fixture list for all the Premier League games. 
        This list includes past as well as upcoming fixtures.
    """.trimIndent(),
    parameters = Schema(
        type = "object",
    ),
    //response = getAllFixtureResponse()
)

val upcomingFixturesFunction = FunctionDeclaration(
    name = upcomingFixturesName,
    description = """
        Gets the upcoming fixture list for the Premier League games. 
        This list includes only the upcoming fixtures and no past fixtures.
    """.trimIndent(),
    parameters = Schema(
        type = "object"
    ),
    //response = getFixtureResponse()
)

internal const val fixturesName = "get_all_fixtures"
internal const val upcomingFixturesName = "get_upcoming_fixtures"


private fun getAllFixtureResponse() = buildJsonObject {
    put("type", "array")
    putJsonObject("items") {
        put("type", "object")
        putJsonObject("properties") {
            getFixture()
        }
    }
}

private fun getFixtureResponse() = buildJsonObject {
    put("type", "object")
    putJsonObject("properties") {
        getFixture()
    }
}

private fun JsonObjectBuilder.getFixture() {
    put(
        "id",
        buildJsonObject {
            put("type", "integer")
            put("description", "The unique id of this fixture")
        }
    )
    put(
        "event",
        buildJsonObject {
            put("type", "integer")
            put("description", "The game week for this fixture")
        }
    )
    put(
        "kickoffTime",
        buildJsonObject {
            put("type", "string")
            put("description", "The match kickoff time in ISO 8601 format")
        }
    )
    put(
        "teamAway",
        buildJsonObject {
            put("type", "integer")
            put("description", "The unique id of the away team")
        }
    )
    put(
        "teamHome",
        buildJsonObject {
            put("type", "integer")
            put("description", "The unique id of the home team")
        }
    )
    put(
        "teamAwayScore",
        buildJsonObject {
            put("type", "integer")
            put("description", "Score of the away team")
            put("nullable", true)
        }
    )
    put(
        "teamHomeScore",
        buildJsonObject {
            put("type", "integer")
            put("description", "Score of the home team")
            put("nullable", true)
        }
    )
    put(
        "teamAwayDifficultyRating",
        buildJsonObject {
            put("type", "integer")
            put("description", "The fixture difficult rating for this fixture for the away team")
        }
    )
    put(
        "teamHomeDifficultyRating",
        buildJsonObject {
            put("type", "integer")
            put("description", "The fixture difficult rating for this fixture for the home team")
        }
    )
    put(
        "finished",
        buildJsonObject {
            put("type", "boolean")
            put("description", "Tells if the fixture is finished")
        }
    )
    put(
        "started",
        buildJsonObject {
            put("type", "boolean")
            put("description", "Tells if the fixture is started")
        }
    )
    put(
        "stats",
        buildJsonObject {
            put("type", "array")
            put("description", "Key statistics for the fixture")
            putJsonObject("items") {
                put("type", "object")
                putJsonObject("properties") {
                    put("identifier", buildJsonObject {
                        put("type", "string")
                        put("description", "The unique name of the stat")
                    })
                    put("a", buildJsonObject {
                        put("type", "array")
                        put("description", "Stat for the away team")
                        putJsonObject("items") {
                            put("type", "object")
                            putJsonObject("properties") {
                                put("value", buildJsonObject {
                                    put("type", "integer")
                                    put("description", "The value or score or number for this stat")
                                })
                                put("element", buildJsonObject {
                                    put("type", "integer")
                                    put("description", "The unique id of the player attributed to this stat")
                                })
                            }
                        }
                    })
                    put("h", buildJsonObject {
                        put("type", "array")
                        put("description", "Stat for the home team")
                        putJsonObject("items") {
                            put("type", "object")
                            putJsonObject("properties") {
                                put("value", buildJsonObject {
                                    put("type", "integer")
                                    put("description", "The value or score or number for this stat")
                                })
                                put("element", buildJsonObject {
                                    put("type", "integer")
                                    put("description", "The unique id of the player attributed to this stat")
                                })
                            }
                        }
                    })
                }
            }
        }
    )
}
