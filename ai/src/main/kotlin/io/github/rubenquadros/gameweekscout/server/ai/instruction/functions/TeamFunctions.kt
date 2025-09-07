package io.github.rubenquadros.gameweekscout.server.ai.instruction.functions

import io.github.rubenquadros.gameweekscout.server.ai.model.FunctionDeclaration
import io.github.rubenquadros.gameweekscout.server.ai.model.Property
import io.github.rubenquadros.gameweekscout.server.ai.model.Schema

internal val allTeamsFunction = FunctionDeclaration(
    name = allTeamsName,
    description = """
        Get the data of all the teams present in the Premier League.
    """.trimIndent(),
    parameters = Schema(
        type = "object"
    )
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
    )
)

internal const val allTeamsName = "get_all_teams"
internal const val teamName = "get_team"