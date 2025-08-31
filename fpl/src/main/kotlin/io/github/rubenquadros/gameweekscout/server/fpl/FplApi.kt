package io.github.rubenquadros.gameweekscout.server.fpl

import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplData
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplElement
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplScoring
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplTeam
import io.github.rubenquadros.gameweekscout.server.fpl.model.fixture.FplFixture
import io.github.rubenquadros.gameweekscout.server.fpl.model.player.FplPlayer

interface FplApi {
    suspend fun refreshData(): FplData?

    suspend fun getAllFixtures(): List<FplFixture>

    suspend fun getUpcomingFixtures(): List<FplFixture>

    suspend fun getAllTeams(): List<FplTeam>

    suspend fun getTeam(id: Int): FplTeam?

    suspend fun getAllPlayers(): List<FplElement>

    suspend fun getPlayer(id: Int): FplPlayer

    suspend fun getScoringData(): FplScoring?
}