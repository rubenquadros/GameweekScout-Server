package io.github.rubenquadros.gameweekscout.server.ai.instruction.functions

import io.github.rubenquadros.gameweekscout.server.ai.model.FunctionDeclaration
import io.github.rubenquadros.gameweekscout.server.ai.model.Schema

val upcomingFixturesFunction = FunctionDeclaration(
    name = upcomingFixturesName,
    description = "Gets upcoming Premier League fixtures for the next 6 gameweeks.",
    parameters = Schema(type = "object")
)

val nextGameWeekFixturesFunction = FunctionDeclaration(
    name = nextGameWeekFixturesName,
    description = "Gets all fixtures for the next Premier League gameweek.",
    parameters = Schema(type = "object")
)

internal const val upcomingFixturesName = "get_upcoming_fixtures"
internal const val nextGameWeekFixturesName = "get_next_gameweek_fixtures"