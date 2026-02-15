package io.github.rubenquadros.gameweekscout.server.fpl

import ai.koog.agents.core.tools.reflect.ToolSet
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplData
import io.github.rubenquadros.gameweekscout.server.fpl.model.simple.FixtureEntity
import io.github.rubenquadros.gameweekscout.server.fpl.model.simple.PlayerEntity
import io.github.rubenquadros.gameweekscout.server.fpl.model.simple.ScoreEntity
import io.github.rubenquadros.gameweekscout.server.fpl.model.simple.TeamEntity

interface FplApi : ToolSet {
    suspend fun refreshData(): FplData?

    suspend fun getUpcomingFixtures(): List<FixtureEntity>

    suspend fun getNextGameWeekFixtures(): List<FixtureEntity>

    suspend fun getAllTeams(): List<TeamEntity>

    suspend fun getTeam(id: Int): TeamEntity?

    //suspend fun getAllPlayers(): List<PlayerEntity>

    suspend fun getMidFielders(): List<PlayerEntity>

    suspend fun getForwards(): List<PlayerEntity>

    suspend fun getDefenders(): List<PlayerEntity>

    suspend fun getGoalkeepers(): List<PlayerEntity>

    suspend fun getPlayer(id: Int): PlayerEntity?

    suspend fun getScoringData(): ScoreEntity?
}