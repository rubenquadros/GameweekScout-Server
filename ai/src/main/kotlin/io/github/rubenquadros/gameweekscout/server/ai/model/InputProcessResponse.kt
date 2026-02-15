package io.github.rubenquadros.gameweekscout.server.ai.model

import ai.koog.agents.core.tools.annotations.LLMDescription
import kotlinx.serialization.Serializable

@Serializable
@LLMDescription("The output format after processing the user query")
data class InputProcessResponse(
    @property:LLMDescription(
        """
           Whether we should proceed to the next step. Will be "true"" only if the query is related to Fantasy Premier League or English Premier League related. 
        """
    )
    val shouldProceed: Boolean,
    @property:LLMDescription("Response of the LLM in the current step")
    val response: String,
    @property:LLMDescription("The original user query which is needed in the next step")
    val originalInput: String
)
