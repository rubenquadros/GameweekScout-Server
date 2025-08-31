package io.github.rubenquadros.gameweekscout.server.fpl

import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplData
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplElement
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplScoring
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplTeam
import io.github.rubenquadros.gameweekscout.server.fpl.model.fixture.FplFixture
import io.github.rubenquadros.gameweekscout.server.fpl.model.player.FplPlayer
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class FplApiImpl(
    private val httpClient: HttpClient
) : FplApi {

    private var fplData: FplData? = null

    override suspend fun refreshData(): FplData? {
        val response = httpClient.get("/api/bootstrap-static")

        fplData = response.body() as? FplData

        return fplData
    }

    override suspend fun getAllFixtures(): List<FplFixture> {
        val response = httpClient.get("/api/fixtures")

        return response.body()
    }

    override suspend fun getUpcomingFixtures(): List<FplFixture> {
        val response = httpClient.get("/api/fixtures?future=1")

        return response.body()
    }

    override suspend fun getAllTeams(): List<FplTeam> {
        if (fplData == null) refreshData()

        return fplData?.teams ?: emptyList()
    }

    override suspend fun getTeam(id: Int): FplTeam? {
        if (fplData == null) refreshData()

        return fplData?.teams?.firstOrNull { it.id == id }
    }

    override suspend fun getAllPlayers(): List<FplElement> {
        if (fplData == null) refreshData()

        return fplData?.elements ?: emptyList()
    }

    override suspend fun getPlayer(id: Int): FplPlayer {
        val response = httpClient.get("/api/element-summary/$id")

        return response.body()
    }

    override suspend fun getScoringData(): FplScoring? {
        if (fplData == null) refreshData()

        return fplData?.gameConfig?.scoring
    }
}