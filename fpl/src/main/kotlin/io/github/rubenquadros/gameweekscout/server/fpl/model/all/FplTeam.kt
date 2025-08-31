package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplTeam(
    @SerialName("code")
    val code: Int,
    @SerialName("draw")
    val draw: Int,
    @SerialName("form")
    val form: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("loss")
    val loss: Int,
    @SerialName("name")
    val name: String,
    @SerialName("played")
    val played: Int,
    @SerialName("points")
    val points: Int,
    @SerialName("position")
    val position: Int,
    @SerialName("short_name")
    val shortName: String,
    @SerialName("strength")
    val strength: Int,
    @SerialName("team_division")
    val teamDivision: String?,
    @SerialName("unavailable")
    val unavailable: Boolean,
    @SerialName("win")
    val win: Int,
    @SerialName("strength_overall_home")
    val strengthOverallHome: Int,
    @SerialName("strength_overall_away")
    val strengthOverallAway: Int,
    @SerialName("strength_attack_home")
    val strengthAttackHome: Int,
    @SerialName("strength_attack_away")
    val strengthAttackAway: Int,
    @SerialName("strength_defence_home")
    val strengthDefenceHome: Int,
    @SerialName("strength_defence_away")
    val strengthDefenceAway: Int,
    @SerialName("pulse_id")
    val pulseId: Int
)
