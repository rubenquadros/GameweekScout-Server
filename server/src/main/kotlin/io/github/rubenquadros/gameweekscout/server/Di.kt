package io.github.rubenquadros.gameweekscout.server

import io.github.rubenquadros.gameweekscout.server.ai.di.AiModule
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.core.annotation.ComponentScan
import org.koin.ktor.plugin.Koin
import org.koin.core.annotation.Module
import org.koin.ksp.generated.module
import org.koin.logger.slf4jLogger

internal fun Application.configureDi() {
    install(Koin) {
        slf4jLogger()
        modules(ServerModule().module)
    }
}

@Module(includes = [AiModule::class])
@ComponentScan("io.github.rubenquadros.gameweekscout.server")
class ServerModule