package io.github.rubenquadros.gameweekscout.server.ai.instruction.functions

import io.github.rubenquadros.gameweekscout.server.ai.model.FunctionDeclaration
import io.github.rubenquadros.gameweekscout.server.ai.model.Schema

val scoringDetailsFunction = FunctionDeclaration(
    name = scoringDetailsName,
    description = """
        Gives details about how points are scored by players in the Fantasy Premier League.
    """.trimIndent(),
    parameters = Schema(
        type = "object"
    )
)

internal const val scoringDetailsName = "get_scoring_details"