package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import ai.koog.agents.core.tools.annotations.LLMDescription
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@LLMDescription("Global configuration and rules for the current FPL season, defining squad limits, transfer rules, and scoring logic.")
data class FplGameSettings(
    @SerialName("league_join_private_max")
    @property:LLMDescription("The maximum number of private leagues a manager is allowed to join (usually 30).")
    val leagueJoinPrivateMax: Int,
    @SerialName("league_join_public_max")
    @property:LLMDescription("The maximum number of public leagues a manager is allowed to join (usually 5).")
    val leagueJoinPublicMax: Int,
    @SerialName("league_max_size_public_classic")
    @property:LLMDescription("The maximum number of teams allowed in a public classic-scoring league.")
    val leagueMaxSizePublicClassic: Int,
    @SerialName("league_max_size_public_h2h")
    @property:LLMDescription("The maximum number of teams allowed in a public Head-to-Head (H2H) league.")
    val leagueMaxSizePublicH2H: Int,
    @SerialName("league_max_size_private_h2h")
    @property:LLMDescription("The maximum number of teams allowed in a private Head-to-Head (H2H) league.")
    val leagueMaxSizePrivateH2H: Int,
    @SerialName("league_max_ko_rounds_private_h2h")
    @property:LLMDescription("The maximum number of knockout rounds permitted in a private H2H league tournament.")
    val leagueMaxKoRoundsPrivateH2H: Int,
    @SerialName("league_prefix_public")
    @property:LLMDescription("The standard prefix used for the names of public leagues (e.g., 'League').")
    val leaguePrefixPublic: String,
    @SerialName("league_points_h2h_win")
    @property:LLMDescription("Points awarded for a win in a Head-to-Head (H2H) league.")
    val leaguePointsH2HWin: Int,
    @SerialName("league_points_h2h_lose")
    @property:LLMDescription("Points awarded for a loss in an H2H league (typically 0).")
    val leaguePointsH2HLose: Int,
    @SerialName("league_points_h2h_draw")
    @property:LLMDescription("Points awarded for a draw in a Head-to-Head (H2H) league.")
    val leaguePointsH2HDraw: Int,
    @SerialName("league_ko_first_instead_of_random")
    @property:LLMDescription("Determines bracket seeding for H2H knockouts; if true, seeds by table position rather than random draw.")
    val leagueKoFirstInsteadOfRandom: Boolean,
    @SerialName("cup_start_event_id")
    @property:LLMDescription("The Gameweek ID when the official FPL Cup begins. Null if not yet announced.")
    val cupStartEventId: Int?,
    @SerialName("cup_stop_event_id")
    @property:LLMDescription("The Gameweek ID when the final of the official FPL Cup takes place.")
    val cupStopEventId: Int?,
    @SerialName("cup_qualifying_method")
    @property:LLMDescription("The criteria used to qualify for the FPL Cup (e.g., based on gameweek rank).")
    val cupQualifyingMethod: String?,
    @SerialName("cup_type")
    @property:LLMDescription("The format or category of the cup competition.")
    val cupType: String?,
    @SerialName("element_sell_at_purchase_price")
    @property:LLMDescription("If true, players are sold for exactly what they were bought for, ignoring market fluctuations.")
    val elementSellAtPurchasePrice: Boolean,
    @SerialName("underdog_differential")
    @property:LLMDescription("A threshold or logic flag used to identify 'underdog' performance relative to the global average.")
    val underdogDifferential: Int,
    @SerialName("squad_squadplay")
    @property:LLMDescription("The number of players who contribute points to the starting XI each gameweek (11).")
    val squadPlay: Int,
    @SerialName("squad_squadsize")
    @property:LLMDescription("The total number of players in a manager's squad (typically 15: 2 GKPs, 5 DEFs, 5 MIDs, 3 FWDs).")
    val squadSize: Int,
    @SerialName("squad_special_min")
    @property:LLMDescription("Minimum requirement for specialized squad types (often null in standard game).")
    val squadSpecialMin: Int?,
    @SerialName("squad_special_max")
    @property:LLMDescription("Maximum limit for specialized squad types (often null in standard game).")
    val squadSpecialMax: Int?,
    @SerialName("squad_team_limit")
    @property:LLMDescription("The maximum number of players a manager can select from a single Premier League club (usually 3).")
    val squadTeamLimit: Int,
    @SerialName("squad_total_spend")
    @property:LLMDescription("The initial total budget allowed for the squad in units of 0.1m (e.g., 1000 = £100.0m).")
    val squadTotalSpend: Int,
    @SerialName("ui_currency_multiplier")
    @property:LLMDescription("The multiplier used to convert raw integer costs to currency values (usually 10, meaning divide by 10 for £).")
    val uiCurrencyMultiplier: Int,
    @SerialName("ui_use_special_shirts")
    @property:LLMDescription("Boolean flag indicating if the interface should display custom/special kits for teams.")
    val uiUseSpecialShirts: Boolean,
    @SerialName("stats_form_days")
    @property:LLMDescription("The rolling window of days used to calculate a player's 'form' rating.")
    val statsFromDays: Int,
    @SerialName("sys_vice_captain_enabled")
    @property:LLMDescription("Whether the vice-captain mechanic (points transfer if captain doesn't play) is active.")
    val sysViceCaptainEnabled: Boolean,
    @SerialName("transfers_cap")
    @property:LLMDescription("The maximum number of accumulated free transfers a manager can hold at once.")
    val transfersCap: Int,
    @SerialName("transfers_sell_on_fee")
    @property:LLMDescription("The portion of profit kept by the game when selling a player (e.g., 0.5 means you keep 50% of the price rise).")
    val transfersSellOnFee: Float,
    @SerialName("max_extra_free_transfers")
    @property:LLMDescription("The maximum number of additional free transfers that can be rolled over or earned.")
    val maxExtraFreeTransfers: Int,
    @SerialName("timezone")
    @property:LLMDescription("The timezone used for all deadline and match timestamps (typically 'UTC').")
    val timezone: String?,
    @SerialName("league_h2h_tiebreak_stats")
    @property:LLMDescription("The priority list of stats used to break ties in H2H league standings (e.g., goals scored).")
    val leagueH2HTiebreakStats: List<String>,
    @SerialName("percentile_ranks")
    @property:LLMDescription("A list of percentile thresholds (e.g., top 1%, 5%, 10%) used to categorize manager performance globally.")
    val percentileRanks: List<Int>
)