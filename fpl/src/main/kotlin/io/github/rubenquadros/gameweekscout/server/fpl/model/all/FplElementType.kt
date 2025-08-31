package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplElementType(
    @SerialName("id")
    val id: Int,
    @SerialName("plural_name")
    val pluralName: String,
    @SerialName("plural_name_short")
    val pluralShort: String,
    @SerialName("singular_name")
    val singularName: String,
    @SerialName("singular_name_short")
    val singularNameShort: String,
    @SerialName("squad_select")
    val squadSelect: Int,
    @SerialName("squad_min_select")
    val squadMinSelect: Int?,
    @SerialName("squad_max_select")
    val squadMaxSelect: Int?,
    @SerialName("squad_min_play")
    val squadMinPlay: Int,
    @SerialName("squad_max_play")
    val squadMaxPlay: Int,
    @SerialName("ui_shirt_specific")
    val uiShirtSpecific: Boolean,
    @SerialName("element_count")
    val elementCount: Long,
    @SerialName("sub_positions_locked")
    val subPositionsLocked: List<Int>
)
