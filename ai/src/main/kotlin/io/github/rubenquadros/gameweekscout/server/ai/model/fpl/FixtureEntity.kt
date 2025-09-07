package io.github.rubenquadros.gameweekscout.server.ai.model.fpl

import io.github.rubenquadros.gameweekscout.server.fpl.model.fixture.FixtureStat
import io.github.rubenquadros.gameweekscout.server.fpl.model.fixture.FplFixture
import kotlinx.serialization.Serializable

@Serializable
internal data class FixtureEntity(
    val id: Int,
    val event: Int,
    val kickoffTime: String?,
    val teamAway: Int,
    val teamHome: Int,
    val teamAwayScore: Int?,
    val teamHomeScore: Int?,
    val teamAwayDifficultyRating: Int?,
    val teamHomeDifficultyRating: Int?,
    val finished: Boolean,
    val started: Boolean?,
    val stats: List<FixtureStat>?
)

internal fun FplFixture.toFixtureEntity() = FixtureEntity(
    id = id,
    event = event,
    kickoffTime = kickoffTime,
    teamAway = teamAway,
    teamHome = teamHome,
    teamAwayScore = teamAwayScore,
    teamHomeScore = teamHomeScore,
    teamAwayDifficultyRating = teamAwayDifficultyRating,
    teamHomeDifficultyRating = teamHomeDifficultyRating,
    started = started,
    finished = finished,
    stats = stats
)

