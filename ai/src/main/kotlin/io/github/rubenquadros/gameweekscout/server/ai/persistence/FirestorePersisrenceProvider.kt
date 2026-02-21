package io.github.rubenquadros.gameweekscout.server.ai.persistence

import ai.koog.agents.snapshot.feature.AgentCheckpointData
import ai.koog.agents.snapshot.providers.PersistenceStorageProvider
import ai.koog.prompt.message.ContentPart
import ai.koog.prompt.message.Message
import ai.koog.prompt.message.ResponseMetaInfo
import com.google.cloud.firestore.Firestore
import kotlinx.datetime.Clock
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Single
import kotlin.collections.filter
import kotlin.time.Duration.Companion.days
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Single
class FirestorePersistenceProvider(
    private val database: Firestore,
    private val json: Json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = true
    }
) : PersistenceStorageProvider<Any> {

    override suspend fun getCheckpoints(
        agentId: String,
        filter: Any?
    ): List<AgentCheckpointData> {
        val data = getLatestCheckpoint(agentId, filter)
        return if (data != null) listOf(data) else emptyList()
    }

    override suspend fun saveCheckpoint(
        agentId: String,
        agentCheckpointData: AgentCheckpointData
    ) {
        //we save only the user and agent messages
        val timeNow = Clock.System.now()
        val fiveDaysAgo = timeNow.minus(5.days)
        val updatedHistory = agentCheckpointData.messageHistory.filter { message ->
            //only user and agent messages including the reasoning output
            message.role == Message.Role.User || message.role == Message.Role.Assistant
        }.filter { message ->
            //purge older messages
            message.metaInfo.timestamp >= fiveDaysAgo
        }
        val userAndAgentData = agentCheckpointData.copy(messageHistory = updatedHistory)
        val data = json.encodeToString(userAndAgentData)
        database.collection("sessions").document(agentId).set(
            UserData(updatedAt = timeNow.toString(), data = data)
        ).await()
    }

    override suspend fun getLatestCheckpoint(
        agentId: String,
        filter: Any?
    ): AgentCheckpointData? {
        return runCatching {
            val doc = database.collection("sessions").document(agentId).get().await()

            if (doc.exists()) {
                val data = doc.getString("data") ?: return null
                val agentCheckpointData = json.decodeFromString<AgentCheckpointData>(data)

                val uniqueMessages = agentCheckpointData.messageHistory.fold(mutableListOf<Message>()) { acc, message ->
                    if (acc.isNotEmpty() && acc.last().role == Message.Role.User && message.role == Message.Role.User) {
                        acc //skip duplicate user
                    } else {
                        acc.apply {
                            add(message) //add message
                        }
                    }
                }

                agentCheckpointData.copy(messageHistory = uniqueMessages)
            } else null
        }.getOrNull()
    }

    suspend fun saveAgentResponse(userId: String, message: String) {
        getLatestCheckpoint(
            agentId = userId,
            filter = null
        )?.let { agentCheckpointData ->
            val updatedData = agentCheckpointData.copy(
                messageHistory = agentCheckpointData.messageHistory.toMutableList().apply {
                    add(
                        Message.Assistant(
                            part = ContentPart.Text(message),
                            metaInfo = ResponseMetaInfo(
                                timestamp = Clock.System.now()
                            )
                        )
                    )
                }
            )

            saveCheckpoint(agentId = userId, agentCheckpointData = updatedData)
        }
    }
}