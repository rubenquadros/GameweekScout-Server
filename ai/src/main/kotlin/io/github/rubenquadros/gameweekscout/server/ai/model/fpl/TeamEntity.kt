package io.github.rubenquadros.gameweekscout.server.ai.model.fpl

import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplTeam
import kotlinx.serialization.Serializable

@Serializable
internal data class TeamEntity(
    val id: Int,
    val name: String,
    val form: String?,
    val strength: Int,
    val strengthOverallHome: Int,
    val strengthOverallAway: Int,
    val strengthAttackHome: Int,
    val strengthAttackAway: Int,
    val strengthDefenceHome: Int,
    val strengthDefenceAway: Int
)

internal fun FplTeam.toTeamEntity() = TeamEntity(
    id = id,
    name = name,
    form = form,
    strength = strength,
    strengthAttackHome = strengthAttackHome,
    strengthAttackAway = strengthAttackAway,
    strengthDefenceHome = strengthAttackHome,
    strengthDefenceAway = strengthDefenceAway,
    strengthOverallHome = strengthOverallHome,
    strengthOverallAway = strengthDefenceAway
)