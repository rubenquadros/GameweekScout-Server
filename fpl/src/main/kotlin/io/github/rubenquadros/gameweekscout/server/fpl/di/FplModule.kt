package io.github.rubenquadros.gameweekscout.server.fpl.di

import io.github.rubenquadros.gameweekscout.client.httpClient
import io.github.rubenquadros.gameweekscout.server.fpl.FplApi
import io.github.rubenquadros.gameweekscout.server.fpl.FplApiImpl
import io.ktor.client.plugins.*
import io.ktor.http.*
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("io.github.rubenquadros.gameweekscout.server.fpl")
class FplModule {

    @Single
    fun provideFplApi(): FplApi {
        return FplApiImpl(
            httpClient = httpClient.config {
                defaultRequest {
                    url {
                        host = "fantasy.premierleague.com"
                        protocol = URLProtocol.HTTPS
                    }
                }
            }
        )
    }
}