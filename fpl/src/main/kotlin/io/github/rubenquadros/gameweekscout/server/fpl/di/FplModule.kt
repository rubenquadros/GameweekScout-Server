package io.github.rubenquadros.gameweekscout.server.fpl.di

import io.github.rubenquadros.gameweekscout.server.fpl.FplApi
import io.github.rubenquadros.gameweekscout.server.fpl.FplApiImpl
import io.github.rubenquadros.gameweekscout.server.fpl.remote.apiClient
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("io.github.rubenquadros.gameweekscout.server.fpl")
class FplModule {

    @Single
    fun provideFplApi(): FplApi {
        return FplApiImpl(httpClient = apiClient)
    }
}