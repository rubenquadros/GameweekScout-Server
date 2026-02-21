package io.github.rubenquadros.gameweekscout.server

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respondNullable

internal fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<Throwable> { call, throwable ->

            call.respondNullable(HttpStatusCode.InternalServerError, ErrorResult(throwable.message.orEmpty()))
        }
    }
}