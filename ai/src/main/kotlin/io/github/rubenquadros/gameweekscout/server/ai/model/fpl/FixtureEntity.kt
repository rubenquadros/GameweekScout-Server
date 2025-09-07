package io.github.rubenquadros.gameweekscout.server.ai.model.fpl

import io.github.rubenquadros.gameweekscout.server.fpl.model.fixture.FplFixture
import kotlinx.serialization.Serializable

@Serializable
internal data class FixtureEntity(
    val id: Int,
    val event: Int,
    val kickoffTime: String?,
    val teamAway: Int,
    val teamHome: Int,
    val teamAwayDifficultyRating: Int?,
    val teamHomeDifficultyRating: Int?
)

internal fun FplFixture.toFixtureEntity() = FixtureEntity(
    id = id,
    event = event,
    kickoffTime = kickoffTime,
    teamAway = teamAway,
    teamHome = teamHome,
    teamAwayDifficultyRating = teamAwayDifficultyRating,
    teamHomeDifficultyRating = teamHomeDifficultyRating
)

