package io.github.rubenquadros.gameweekscout.server

import io.github.rubenquadros.gameweekscout.client.ApiException
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respondNullable

internal fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<Throwable> { call, throwable ->
            val status = when (throwable) {
                is ApiException -> HttpStatusCode.FailedDependency
                else -> HttpStatusCode.InternalServerError
            }

            call.respondNullable(status, ErrorResult(throwable.message.orEmpty()))
        }
    }
}