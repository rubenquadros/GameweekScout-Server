package io.github.rubenquadros.gameweekscout.server.fpl.model.simple

import ai.koog.agents.core.tools.annotations.LLMDescription
import io.github.rubenquadros.gameweekscout.server.fpl.model.all.FplTeam
import kotlinx.serialization.Serializable

@Serializable
@LLMDescription("A Premier League club.")
data class TeamEntity(
    @property:LLMDescription("Unique internal identifier for the club (1 to 20).")
    val id: Int,
    @property:LLMDescription("The full name of the club, e.g., 'Arsenal'.")
    val name: String,
    @property:LLMDescription("The 3-letter abbreviation of the club, e.g., 'ARS'.")
    val shortName: String,
    @property:LLMDescription("A string representation of the team's recent results (e.g., 'WWDLD').")
    val form: String?,
    @property:LLMDescription("A rating of the team's overall difficulty/strength.")
    val strength: Int,
    @property:LLMDescription("Overall strength rating when the team is playing at home (higher is stronger).")
    val strengthOverallHome: Int,
    @property:LLMDescription("Overall strength rating when the team is playing away (higher is stronger).")
    val strengthOverallAway: Int,
    @property:LLMDescription("Attacking/Offensive strength rating for home matches.")
    val strengthAttackHome: Int,
    @property:LLMDescription("Attacking/Offensive strength rating for away matches.")
    val strengthAttackAway: Int,
    @property:LLMDescription("Defensive strength rating for home matches.")
    val strengthDefenceHome: Int,
    @property:LLMDescription("Defensive strength rating for away matches.")
    val strengthDefenceAway: Int
)

internal fun FplTeam.toTeamEntity() = TeamEntity(
    id = id,
    name = name,
    shortName = shortName,
    form = form,
    strength = strength,
    strengthAttackHome = strengthAttackHome,
    strengthAttackAway = strengthAttackAway,
    strengthDefenceHome = strengthAttackHome,
    strengthDefenceAway = strengthDefenceAway,
    strengthOverallHome = strengthOverallHome,
    strengthOverallAway = strengthDefenceAway
)