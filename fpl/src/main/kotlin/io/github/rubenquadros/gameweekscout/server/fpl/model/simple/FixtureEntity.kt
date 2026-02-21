package io.github.rubenquadros.gameweekscout.server.fpl.model.simple

import ai.koog.agents.core.tools.annotations.LLMDescription
import io.github.rubenquadros.gameweekscout.server.fpl.model.fixture.FplFixture
import kotlinx.serialization.Serializable

@Serializable
@LLMDescription("Represents an individual match in the Premier League schedule, including scheduling, difficulty ratings, and score tracking.")
data class FixtureEntity(
    @property:LLMDescription("Internal unique identifier for the fixture.")
    val id: Int,
    @property:LLMDescription("The ID of the Gameweek (Event) in which this fixture takes place.")
    val event: Int,
    @property:LLMDescription("The scheduled start time of the match in ISO 8601 format (UTC).")
    val kickoffTime: String?,
    @property:LLMDescription("The internal ID of the Away team.")
    val teamAway: Int,
    @property:LLMDescription("The internal ID of the Home team.")
    val teamHome: Int,
    @property:LLMDescription("The Fixture Difficulty Rating (FDR) for the Away team (1-5 scale).")
    val teamAwayDifficultyRating: Int?,
    @property:LLMDescription("The Fixture Difficulty Rating (FDR) for the Home team (1-5 scale).")
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

