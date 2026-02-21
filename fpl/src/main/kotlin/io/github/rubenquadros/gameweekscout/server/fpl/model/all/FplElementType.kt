package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import ai.koog.agents.core.tools.annotations.LLMDescription
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@LLMDescription("Metadata for a player position.")
data class FplElementType(
    @SerialName("id")
    @property:LLMDescription("The unique identifier for the position (1: GKP, 2: DEF, 3: MID, 4: FWD).")
    val id: Int,
    @SerialName("plural_name")
    @property:LLMDescription("The full plural name of the position, e.g., 'Goalkeepers'.")
    val pluralName: String,
    @SerialName("plural_name_short")
    @property:LLMDescription("The short plural abbreviation for the position, e.g., 'GKP', 'DEF'.")
    val pluralShort: String,
    @SerialName("singular_name")
    @property:LLMDescription("The full name of the position (e.g., 'Goalkeeper').")
    val singularName: String,
    @SerialName("singular_name_short")
    @property:LLMDescription("The short name of the position (e.g., 'GKP').")
    val singularNameShort: String,
    @SerialName("squad_select")
    @property:LLMDescription("The exact number of players of this position required for a complete 15-man squad (e.g., 2 for GKP, 5 for DEF).")
    val squadSelect: Int,
    @SerialName("squad_min_select")
    @property:LLMDescription("The minimum number of players of this position allowed in a squad (usually null as squad_select is fixed).")
    val squadMinSelect: Int?,
    @SerialName("squad_max_select")
    @property:LLMDescription("The maximum number of players of this position allowed in a squad (usually null).")
    val squadMaxSelect: Int?,
    @SerialName("squad_min_play")
    @property:LLMDescription("The minimum number of players of this position that must be in the starting XI (e.g., 3 for Defenders).")
    val squadMinPlay: Int,
    @SerialName("squad_max_play")
    @property:LLMDescription("The maximum number of players of this position permitted in the starting XI (e.g., 3 for Forwards).")
    val squadMaxPlay: Int,
    @SerialName("ui_shirt_specific")
    @property:LLMDescription("Boolean indicating if the UI uses a specialized shirt icon for this position (typically true for Goalkeepers).")
    val uiShirtSpecific: Boolean,
    @SerialName("element_count")
    @property:LLMDescription("The total number of players currently in the game belonging to this position type.")
    val elementCount: Long,
    @SerialName("sub_positions_locked")
    @property:LLMDescription("A list of internal sub-position identifiers that are restricted or specifically locked for this type.")
    val subPositionsLocked: List<Int>
)
