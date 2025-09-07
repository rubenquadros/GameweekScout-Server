package io.github.rubenquadros.gameweekscout.server.fpl

import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplData
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplElement
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplScoring
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplTeam
import io.github.rubenquadros.gameweekscout.server.fpl.model.fixture.FplFixture

interface FplApi {
    suspend fun refreshData(): FplData?

    suspend fun getUpcomingFixtures(): List<FplFixture>

    suspend fun getNextGameWeekFixtures(): List<FplFixture>

    suspend fun getAllTeams(): List<FplTeam>

    suspend fun getTeam(id: Int): FplTeam?

    suspend fun getAllPlayers(): List<FplElement>

    suspend fun getMidFielders(): List<FplElement>

    suspend fun getForwards(): List<FplElement>

    suspend fun getDefenders(): List<FplElement>

    suspend fun getGoalkeepers(): List<FplElement>

    suspend fun getPlayer(id: Int): FplElement?

    suspend fun getScoringData(): FplScoring?
}