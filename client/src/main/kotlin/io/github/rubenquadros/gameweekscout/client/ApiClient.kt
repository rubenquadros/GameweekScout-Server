package io.github.rubenquadros.gameweekscout.client

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlin.time.Duration.Companion.seconds

val httpClient: HttpClient by lazy {
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
    }
}

fun HttpClientConfig<*>.addResponseHandler(errorMessage: suspend HttpResponse.() -> String) {
    HttpResponseValidator {
        validateResponse { response ->
            if (!response.status.isSuccess()) {
                throw ApiException(message = "There was an API error: ${errorMessage(response)}")
            }
        }
    }
}