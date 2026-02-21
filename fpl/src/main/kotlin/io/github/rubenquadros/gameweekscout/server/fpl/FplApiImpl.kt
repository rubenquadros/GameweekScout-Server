package io.github.rubenquadros.gameweekscout.server.fpl

import ai.koog.agents.core.tools.annotations.LLMDescription
import ai.koog.agents.core.tools.annotations.Tool
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplData
import io.github.rubenquadros.gameweekscout.server.fpl.model.fixture.FplFixture
import io.github.rubenquadros.gameweekscout.server.fpl.model.simple.*
import io.github.rubenquadros.gameweekscout.server.fpl.remote.apiClient
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

@LLMDescription("Tools for getting FPL data")
internal class FplApiImpl(
    private val httpClient: HttpClient = apiClient
) : FplApi {

    private var fplData: FplData? = null

    override suspend fun refreshData(): FplData? {
        val response = httpClient.get("/api/bootstrap-static")

        fplData = response.body() as? FplData

        return fplData
    }

    @Tool
    @LLMDescription("Get the upcoming fixtures for the next 6 game weeks")
    override suspend fun getUpcomingFixtures(): List<FixtureEntity> {
        val response = httpClient.get("/api/fixtures?future=1")

        //get all upcoming fixture
        val fixtures = response.body<List<FplFixture>>()

        //filter upcoming 6 game weeks
        val upcomingGameWeek = fixtures.firstOrNull()?.event ?: return emptyList()

        val nextSixGameWeeks = upcomingGameWeek + 5

        return fixtures.filter {
            it.event < nextSixGameWeeks
        }.map {
            it.toFixtureEntity()
        }
    }

    @Tool
    @LLMDescription("Get the upcoming fixtures for the next game week")
    override suspend fun getNextGameWeekFixtures(): List<FixtureEntity> {
        val allUpcomingFixtures = getUpcomingFixtures()

        val nextGameWeek = allUpcomingFixtures.firstOrNull()?.event

        return allUpcomingFixtures.filter { it.event == nextGameWeek }
    }

    @Tool
    @LLMDescription("Get the details of all the teams in the current Premier League")
    override suspend fun getAllTeams(): List<TeamEntity> {
        if (fplData == null) refreshData()

        return fplData?.teams?.map { it.toTeamEntity() } ?: emptyList()
    }

    @Tool
    @LLMDescription("Get the details of a particular team in the current Premier League")
    override suspend fun getTeam(
        @LLMDescription("The id of the team")
        id: Int
    ): TeamEntity? {
        if (fplData == null) refreshData()

        return fplData?.teams?.firstOrNull { it.id == id }?.toTeamEntity()
    }

//    @Tool
//    @LLMDescription("Get the details of all the players playing in the current Premier League")
//    override suspend fun getAllPlayers(): List<PlayerEntity> {
//        if (fplData == null) refreshData()
//
//        return fplData?.elements?.map { it.toPlayerEntity() } ?: emptyList()
//    }

    @Tool
    @LLMDescription("Get the details of all the mid field players playing in the current Premier League")
    override suspend fun getMidFielders(): List<PlayerEntity> {
        if (fplData == null) refreshData()

        return fplData?.elements?.filter {
            it.elementType == 3
        }?.map {
            it.toPlayerEntity()
        } ?: emptyList()
    }
    @Tool
    @LLMDescription("Get the details of all the forward players playing in the current Premier League")
    override suspend fun getForwards(): List<PlayerEntity> {
        if (fplData == null) refreshData()

        return fplData?.elements?.filter {
            it.elementType == 4
        }?.map {
            it.toPlayerEntity()
        } ?: emptyList()
    }

    @Tool
    @LLMDescription("Get the details of all the defensive players (defenders) playing in the current Premier League")
    override suspend fun getDefenders(): List<PlayerEntity> {
        if (fplData == null) refreshData()

        return fplData?.elements?.filter {
            it.elementType == 2
        }?.map {
            it.toPlayerEntity()
        } ?: emptyList()
    }

    @Tool
    @LLMDescription("Get the details of all the goal keepers playing in the current Premier League")
    override suspend fun getGoalkeepers(): List<PlayerEntity> {
        if (fplData == null) refreshData()

        return fplData?.elements?.filter {
            it.elementType == 1
        }?.map {
            it.toPlayerEntity()
        } ?: emptyList()
    }

    @Tool
    @LLMDescription("Get the details of a particular player playing in the current Premier League")
    override suspend fun getPlayer(
        @LLMDescription("The id of the player")
        id: Int
    ): PlayerEntity? {
        if (fplData == null) refreshData()

        return fplData?.elements?.firstOrNull { it.id == id }?.toPlayerEntity()
    }

    @Tool
    @LLMDescription("Gets the details about how points are scored by players in the Fantasy Premier League.")
    override suspend fun getScoringData(): ScoreEntity? {
        if (fplData == null) refreshData()

        return fplData?.gameConfig?.scoring?.toScoreEntity()
    }
}