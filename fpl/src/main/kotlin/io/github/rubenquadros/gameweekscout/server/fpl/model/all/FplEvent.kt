package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplEvent(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("deadline_time")
    val deadlineTime: String,
    @SerialName("deadline_time_epoch")
    val deadlineTimeEpoch: Long,
    @SerialName("deadline_time_game_offset")
    val deadlineTimeGameOffset: Long,
    @SerialName("release_time")
    val releaseTime: String?,
    @SerialName("average_entry_score")
    val averageEntryScore: Float,
    @SerialName("finished")
    val finished: Boolean,
    @SerialName("data_checked")
    val dataChecked: Boolean,
    @SerialName("highest_scoring_entry")
    val highestScoringEntry: Long?,
    @SerialName("highest_score")
    val highestScore: Long?,
    @SerialName("is_previous")
    val isPrevious: Boolean,
    @SerialName("is_current")
    val isCurrent: Boolean,
    @SerialName("is_next")
    val isNext: Boolean,
    @SerialName("cup_leagues_created")
    val cupLeaguesCreated: Boolean,
    @SerialName("h2h_ko_matches_created")
    val h2hKoMatchesCreated: Boolean,
    @SerialName("can_enter")
    val canEnter: Boolean,
    @SerialName("can_manage")
    val canManage: Boolean,
    @SerialName("released")
    val released: Boolean,
    @SerialName("ranked_count")
    val rankedCount: Long,
    @SerialName("most_selected")
    val mostSelected: Long?,
    @SerialName("most_transferred_in")
    val mostTransferredIn: Long?,
    @SerialName("top_element")
    val topElement: Long?,
    @SerialName("top_element_info")
    val topElementInfo: TopElementInfo?,
    @SerialName("transfers_made")
    val transfersMade: Long,
    @SerialName("most_captained")
    val mostCaptained: Long?,
    @SerialName("most_vice_captained")
    val mostViceCaptained: Long?,
    @SerialName("chips_played")
    val chipsPlayed: List<FplChipPlayed>?
)

@Serializable
data class TopElementInfo(
    @SerialName("id")
    val id: Int,
    @SerialName("points")
    val points: Int
)
