package io.github.rubenquadros.gameweekscout.server.fpl.model.all

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FplGameSettings(
    @SerialName("league_join_private_max")
    val leagueJoinPrivateMax: Int,
    @SerialName("league_join_public_max")
    val leagueJoinPublicMax: Int,
    @SerialName("league_max_size_public_classic")
    val leagueMaxSizePublicClassic: Int,
    @SerialName("league_max_size_public_h2h")
    val leagueMaxSizePublicH2H: Int,
    @SerialName("league_max_size_private_h2h")
    val leagueMaxSizePrivateH2H: Int,
    @SerialName("league_max_ko_rounds_private_h2h")
    val leagueMaxKoRoundsPrivateH2H: Int,
    @SerialName("league_prefix_public")
    val leaguePrefixPublic: String,
    @SerialName("league_points_h2h_win")
    val leaguePointsH2HWin: Int,
    @SerialName("league_points_h2h_lose")
    val leaguePointsH2HLose: Int,
    @SerialName("league_points_h2h_draw")
    val leaguePointsH2HDraw: Int,
    @SerialName("league_ko_first_instead_of_random")
    val leagueKoFirstInsteadOfRandom: Boolean,
    @SerialName("cup_start_event_id")
    val cupStartEventId: Int?,
    @SerialName("cup_stop_event_id")
    val cupStopEventId: Int?,
    @SerialName("cup_qualifying_method")
    val cupQualifyingMethod: String?,
    @SerialName("cup_type")
    val cupType: String?,
    @SerialName("element_sell_at_purchase_price")
    val elementSellAtPurchasePrice: Boolean,
    @SerialName("underdog_differential")
    val underdogDifferential: Int,
    @SerialName("squad_squadplay")
    val squadPlay: Int,
    @SerialName("squad_squadsize")
    val squadSize: Int,
    @SerialName("squad_special_min")
    val squadSpecialMin: Int?,
    @SerialName("squad_special_max")
    val squadSpecialMax: Int?,
    @SerialName("squad_team_limit")
    val squadTeamLimit: Int,
    @SerialName("squad_total_spend")
    val squadTotalSpend: Int,
    @SerialName("ui_currency_multiplier")
    val uiCurrencyMultiplier: Int,
    @SerialName("ui_use_special_shirts")
    val uiUseSpecialShirts: Boolean,
    @SerialName("stats_form_days")
    val statsFromDays: Int,
    @SerialName("sys_vice_captain_enabled")
    val sysViceCaptainEnabled: Boolean,
    @SerialName("transfers_cap")
    val transfersCap: Int,
    @SerialName("transfers_sell_on_fee")
    val transfersSellOnFee: Float,
    @SerialName("max_extra_free_transfers")
    val maxExtraFreeTransfers: Int,
    @SerialName("timezone")
    val timezone: String?,
    @SerialName("league_h2h_tiebreak_stats")
    val leagueH2HTiebreakStats: List<String>,
    @SerialName("percentile_ranks")
    val percentileRanks: List<Int>
)