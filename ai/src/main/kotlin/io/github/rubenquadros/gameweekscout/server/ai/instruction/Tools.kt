package io.github.rubenquadros.gameweekscout.server.ai.instruction

import io.github.rubenquadros.gameweekscout.server.ai.instruction.functions.allFixturesFunction
import io.github.rubenquadros.gameweekscout.server.ai.instruction.functions.allPlayersFunction
import io.github.rubenquadros.gameweekscout.server.ai.instruction.functions.allTeamsFunction
import io.github.rubenquadros.gameweekscout.server.ai.instruction.functions.playerFunction
import io.github.rubenquadros.gameweekscout.server.ai.instruction.functions.scoringDetailsFunction
import io.github.rubenquadros.gameweekscout.server.ai.instruction.functions.teamFunction
import io.github.rubenquadros.gameweekscout.server.ai.instruction.functions.upcomingFixturesFunction
import io.github.rubenquadros.gameweekscout.server.ai.model.SystemTool

internal val fplTool = SystemTool(
    functionDeclarations = listOf(
        allFixturesFunction,
        upcomingFixturesFunction,
        allTeamsFunction,
        teamFunction,
        allPlayersFunction,
        playerFunction,
        scoringDetailsFunction
    )
)