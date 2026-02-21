package io.github.rubenquadros.gameweekscout.server.fpl.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlin.time.Duration.Companion.seconds

val apiClient: HttpClient by lazy {
    HttpClient(OkHttp){
        install(ContentNegotiation) {
            json(Json {
                isLenient = true
                ignoreUnknownKeys = true
                prettyPrint = true
                encodeDefaults = true
                explicitNulls = false
            })
        }

        install(Logging) {
            level = LogLevel.ALL
        }

        install(HttpTimeout) {
            connectTimeoutMillis = 10.seconds.inWholeMilliseconds

            //These are set to a higher limit to account for the server cold start
            requestTimeoutMillis = 50.seconds.inWholeMilliseconds
            socketTimeoutMillis = 50.seconds.inWholeMilliseconds
        }

        defaultRequest {
            url {
                host = "fantasy.premierleague.com"
                protocol = URLProtocol.HTTPS
            }
        }
    }
}