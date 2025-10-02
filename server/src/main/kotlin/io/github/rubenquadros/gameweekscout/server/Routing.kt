package io.github.rubenquadros.gameweekscout.server

import io.github.rubenquadros.gameweekscout.server.ai.ScoutService
import io.github.rubenquadros.gameweekscout.server.ai.model.Content
import io.ktor.http.HttpStatusCode
import io.ktor.resources.Resource
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.request.receive
import io.ktor.server.resources.Resources
import io.ktor.server.resources.post
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject

internal fun Application.configureRouting() {
    install(Resources)

    routing {
        mainRoute()
    }
}

internal fun Route.mainRoute() {
    val scoutService by inject<ScoutService>()

    post<MainRoute> {
        val body = call.receive<List<Content>>()
        val response = scoutService.getScoutAdvice(body)

        if (response != null) {
            call.respond(status = HttpStatusCode.OK, message = response)
        } else {
            call.respond(HttpStatusCode.InternalServerError)
        }
    }
}

@Resource("/scout-advice")
internal class MainRoute