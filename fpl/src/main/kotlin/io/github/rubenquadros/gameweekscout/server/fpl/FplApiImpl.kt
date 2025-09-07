package io.github.rubenquadros.gameweekscout.server.fpl

import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplData
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplElement
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplScoring
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplTeam
import io.github.rubenquadros.gameweekscout.server.fpl.model.fixture.FplFixture
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

    override suspend fun getUpcomingFixtures(): List<FplFixture> {
        val response = httpClient.get("/api/fixtures?future=1")

        //get all upcoming fixture
        val fixtures = response.body<List<FplFixture>>()

        //filter upcoming 6 game weeks
        val upcomingGameWeek = fixtures.firstOrNull()?.event

        if (upcomingGameWeek == null) return emptyList()

        val nextSixGameWeeks = upcomingGameWeek + 5

        return fixtures.filter {
            it.event < nextSixGameWeeks
        }
    }

    override suspend fun getNextGameWeekFixtures(): List<FplFixture> {
        val allUpcomingFixtures = getUpcomingFixtures()

        val nextGameWeek = allUpcomingFixtures.firstOrNull()?.event

        return allUpcomingFixtures.filter { it.event == nextGameWeek }
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

    override suspend fun getMidFielders(): List<FplElement> {
        if (fplData == null) refreshData()

        return fplData?.elements?.filter { it.elementType == 3 } ?: emptyList()
    }

    override suspend fun getForwards(): List<FplElement> {
        if (fplData == null) refreshData()

        return fplData?.elements?.filter { it.elementType == 4 } ?: emptyList()
    }

    override suspend fun getDefenders(): List<FplElement> {
        if (fplData == null) refreshData()

        return fplData?.elements?.filter { it.elementType == 2 } ?: emptyList()
    }

    override suspend fun getGoalkeepers(): List<FplElement> {
        if (fplData == null) refreshData()

        return fplData?.elements?.filter { it.elementType == 1 } ?: emptyList()
    }

    override suspend fun getPlayer(id: Int): FplElement? {
        if (fplData == null) refreshData()

        return fplData?.elements?.firstOrNull { it.id == id }
    }

    override suspend fun getScoringData(): FplScoring? {
        if (fplData == null) refreshData()

        return fplData?.gameConfig?.scoring
    }
}