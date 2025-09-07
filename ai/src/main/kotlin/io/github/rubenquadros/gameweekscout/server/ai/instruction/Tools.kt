package io.github.rubenquadros.gameweekscout.server.ai.instruction

import io.github.rubenquadros.gameweekscout.server.ai.instruction.functions.*
import io.github.rubenquadros.gameweekscout.server.ai.model.SystemTool

internal val fplTool = SystemTool(
    functionDeclarations = listOf(
        upcomingFixturesFunction,
        nextGameWeekFixturesFunction,
        allTeamsFunction,
        teamFunction,
        allPlayersFunction,
        forwardsFunction,
        midfieldersFunction,
        defendersFunction,
        goalkeepersFunction,
        playerFunction,
        scoringDetailsFunction
    )
)