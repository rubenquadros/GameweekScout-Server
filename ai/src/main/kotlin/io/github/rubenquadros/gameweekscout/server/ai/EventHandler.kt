package io.github.rubenquadros.gameweekscout.server.ai

import ai.koog.agents.features.eventHandler.feature.EventHandlerConfig

internal fun EventHandlerConfig.eventHandler() {
    onAgentStarting {
        println("handleEvents:: onAgentStarting: ${it.agent.agentConfig.model}")
    }

    onToolCallStarting {
        println("handleEvents:: onToolCallStarting: ${it.toolName}")
    }

    onToolCallFailed {
        println("handleEvents:: onToolCallFailed: ${it.toolName}")
    }

    onToolCallCompleted {
        println("handleEvents:: onToolCallCompleted: ${it.toolName}")
    }

    onStrategyStarting {
        println("handleEvents:: onStrategyStarting: ${it.strategy.name}")
    }

    onStrategyCompleted {
        println("handleEvents:: onStrategyCompleted: ${it.strategy.name}")
    }

    onSubgraphExecutionStarting {
        println("handleEvents:: onSubgraphExecutionStarting: ${it.subgraph.name}")
    }

    onSubgraphExecutionFailed {
        println("handleEvents:: onSubgraphExecutionFailed: ${it.subgraph.name}")
    }

    onSubgraphExecutionCompleted {
        println("handleEvents:: onSubgraphExecutionCompleted: ${it.subgraph.name}")
    }

    onAgentCompleted {
        println("handleEvents:: onAgentCompleted: ${it.result}")
    }
}