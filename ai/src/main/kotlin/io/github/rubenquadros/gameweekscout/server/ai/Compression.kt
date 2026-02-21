package io.github.rubenquadros.gameweekscout.server.ai

import ai.koog.agents.memory.model.Concept
import ai.koog.agents.memory.model.FactType

internal val fplConceptsToCompressHistory = listOf(
    Concept(
        keyword = "user-team",
        description = "What is the user's current FPL team composition? Which players do they own?",
        factType = FactType.MULTIPLE
    ),
    Concept(
        keyword = "budget-status",
        description = "How much in the bank (ITB) does the user have? Any recent transfers made?",
        factType = FactType.SINGLE
    ),
    Concept(
        keyword = "previous-advice",
        description = "What squad advice was previously given? Which gameweek was it for?",
        factType = FactType.MULTIPLE
    ),
    Concept(
        keyword = "user-preferences",
        description = "Does the user prefer certain players, formations, or strategies?",
        factType = FactType.MULTIPLE
    )
)