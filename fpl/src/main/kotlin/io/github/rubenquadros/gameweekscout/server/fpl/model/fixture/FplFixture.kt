package io.github.rubenquadros.gameweekscout.server.fpl.model.fixture

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplFixture(
    @SerialName("code")
    val code: Int,
    @SerialName("event")
    val event: Int,
    @SerialName("event_name")
    val eventName: String?,
    @SerialName("finished")
    val finished: Boolean,
    @SerialName("finished_provisional")
    val finishedProvisional: Boolean?,
    @SerialName("id")
    val id: Int,
    @SerialName("kickoff_time")
    val kickoffTime: String,
    @SerialName("minutes")
    val minutes: Int,
    @SerialName("provisional_start_time")
    val provisionalStartTime: Boolean,
    @SerialName("started")
    val started: Boolean?,
    @SerialName("team_a")
    val teamAway: Int,
    @SerialName("team_a_score")
    val teamAwayScore: Int?,
    @SerialName("team_a_difficulty")
    val teamAwayDifficultyRating: Int?,
    @SerialName("team_h")
    val teamHome: Int,
    @SerialName("team_h_score")
    val teamHomeScore: Int?,
    @SerialName("team_h_difficulty")
    val teamHomeDifficultyRating: Int?,
    @SerialName("stats")
    val stats: List<FixtureStat>?,
    @SerialName("is_home")
    val isHome: Boolean?,
    @SerialName("difficulty")
    val difficulty: Int?
)