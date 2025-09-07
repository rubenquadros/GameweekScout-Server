package io.github.rubenquadros.gameweekscout.server.ai.instruction.functions

import io.github.rubenquadros.gameweekscout.server.ai.model.FunctionDeclaration
import io.github.rubenquadros.gameweekscout.server.ai.model.Property
import io.github.rubenquadros.gameweekscout.server.ai.model.Schema

val allPlayersFunction = FunctionDeclaration(
    name = allPlayersName,
    description = "Get the Fantasy Premier League data of all the players.",
    parameters = Schema(type = "object")
)

val midfieldersFunction = FunctionDeclaration(
    name = midfieldersName,
    description = "Get the Fantasy Premier League data of all the midfielders.",
    parameters = Schema(type = "object")
)

val forwardsFunction = FunctionDeclaration(
    name = forwardsName,
    description = "Get the Fantasy Premier League data of all the forwards.",
    parameters = Schema(type = "object")
)

val defendersFunction = FunctionDeclaration(
    name = defendersName,
    description = "Get the Fantasy Premier League data of all the defenders.",
    parameters = Schema(type = "object")
)

val goalkeepersFunction = FunctionDeclaration(
    name = goalkeepersName,
    description = "Get the Fantasy Premier League data of all the goalkeepers.",
    parameters = Schema(type = "object")
)

val playerFunction = FunctionDeclaration(
    name = playerName,
    description = "Get the Fantasy Premier League data of a specific player.",
    parameters = Schema(
        type = "object",
        properties = mapOf(
            "id" to Property(
                type = "integer",
                description = "The unique id of the player"
            )
        ),
        required = listOf("id")
    )
)

internal const val allPlayersName = "get_all_players"
internal const val midfieldersName = "get_midfielders"
internal const val forwardsName = "get_forwards"
internal const val defendersName = "get_defenders"
internal const val goalkeepersName = "get_goalkeepers"
internal const val playerName = "get_player"