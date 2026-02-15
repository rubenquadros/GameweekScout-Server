package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import ai.koog.agents.core.tools.annotations.LLMDescription
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@LLMDescription("A specific Gameweek event.")
data class FplEvent(
    @SerialName("id")
    @property:LLMDescription("The unique ID of the gameweek, e.g., 1, 2, 3.")
    val id: Int,
    @SerialName("name")
    @property:LLMDescription("The name of the gameweek, e.g., 'Gameweek 1'.")
    val name: String,
    @SerialName("deadline_time")
    @property:LLMDescription("The ISO 8601 timestamp for the transfer and team selection deadline.")
    val deadlineTime: String,
    @SerialName("deadline_time_epoch")
    @property:LLMDescription("The Unix timestamp (seconds) for the gameweek deadline.")
    val deadlineTimeEpoch: Long,
    @SerialName("deadline_time_game_offset")
    @property:LLMDescription("The number of seconds before the first match that the deadline occurs.")
    val deadlineTimeGameOffset: Long,
    @SerialName("release_time")
    @property:LLMDescription("The time when the gameweek's data was made available.")
    val releaseTime: String?,
    @SerialName("average_entry_score")
    @property:LLMDescription("The average score achieved by all managers in this gameweek.")
    val averageEntryScore: Float,
    @SerialName("finished")
    @property:LLMDescription("True if all matches in this gameweek are finished and points are finalized.")
    val finished: Boolean,
    @SerialName("data_checked")
    @property:LLMDescription("True if FPL has completed all post-match data validation and bonus point allocations.")
    val dataChecked: Boolean,
    @SerialName("highest_scoring_entry")
    @property:LLMDescription("The unique ID of the manager's team (entry) that achieved the highest score.")
    val highestScoringEntry: Long?,
    @SerialName("highest_score")
    @property:LLMDescription("The highest number of points scored by a single manager in this gameweek.")
    val highestScore: Long?,
    @SerialName("is_previous")
    @property:LLMDescription("True if this gameweek was the one immediately preceding the current active one.")
    val isPrevious: Boolean,
    @SerialName("is_current")
    @property:LLMDescription("True if the gameweek is currently active or being played.")
    val isCurrent: Boolean,
    @SerialName("is_next")
    @property:LLMDescription("True if this is the next upcoming gameweek.")
    val isNext: Boolean,
    @SerialName("cup_leagues_created")
    @property:LLMDescription("Indicates if cup competition brackets for this gameweek have been generated.")
    val cupLeaguesCreated: Boolean,
    @SerialName("h2h_ko_matches_created")
    @property:LLMDescription("Indicates if Head-to-Head knockout matches have been generated.")
    val h2hKoMatchesCreated: Boolean,
    @SerialName("can_enter")
    @property:LLMDescription("True if new managers can still join the game starting from this gameweek.")
    val canEnter: Boolean,
    @SerialName("can_manage")
    @property:LLMDescription("True if managers are currently allowed to make changes to their teams for this gameweek.")
    val canManage: Boolean,
    @SerialName("released")
    @property:LLMDescription("True if the gameweek has been officially released by the game engine.")
    val released: Boolean,
    @SerialName("ranked_count")
    @property:LLMDescription("The total number of managers who were ranked in this gameweek.")
    val rankedCount: Long,
    @SerialName("most_selected")
    @property:LLMDescription("The player ID of the individual owned by the most managers for this gameweek.")
    val mostSelected: Long?,
    @SerialName("most_transferred_in")
    @property:LLMDescription("The player ID of the individual who was transferred into the most teams for this gameweek.")
    val mostTransferredIn: Long?,
    @SerialName("top_element")
    @property:LLMDescription("The player ID of the individual who scored the most points this gameweek.")
    val topElement: Long?,
    @SerialName("top_element_info")
    @property:LLMDescription("Details (usually points) regarding the highest-scoring player (top_element).")
    val topElementInfo: TopElementInfo?,
    @SerialName("transfers_made")
    @property:LLMDescription("The total number of player transfers made by all managers specifically for this gameweek.")
    val transfersMade: Long,
    @SerialName("most_captained")
    @property:LLMDescription("The player ID of the individual most frequently chosen as captain.")
    val mostCaptained: Long?,
    @SerialName("most_vice_captained")
    @property:LLMDescription("The player ID of the individual most frequently chosen as vice-captain.")
    val mostViceCaptained: Long?,
    @SerialName("chips_played")
    @property:LLMDescription("A summary of special chips (Wildcard, Free Hit, etc.) used by the community during this gameweek.")
    val chipsPlayed: List<FplChipPlayed>?
)

@Serializable
@LLMDescription("Information about the player who achieved the highest point total in a specific gameweek.")
data class TopElementInfo(
    @SerialName("id")
    @property:LLMDescription("The unique internal identifier (ID) of the highest-scoring player for this event.")
    val id: Int,
    @SerialName("points")
    @property:LLMDescription("The total number of points earned by this player during this specific gameweek.")
    val points: Int
)
