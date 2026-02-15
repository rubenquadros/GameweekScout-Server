package io.github.rubenquadros.gameweekscout.server.ai.di

import io.github.rubenquadros.gameweekscout.server.ai.ScoutService
import io.github.rubenquadros.gameweekscout.server.ai.ScoutServiceImpl
import io.github.rubenquadros.gameweekscout.server.fpl.FplApi
import io.github.rubenquadros.gameweekscout.server.fpl.di.FplModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module(includes = [FplModule::class])
@ComponentScan("io.github.rubenquadros.gameweekscout.server.ai")
class AiModule {

    @Single
    fun provideScoutService(fplApi: FplApi): ScoutService {
        return ScoutServiceImpl(fplApi = fplApi)
    }
}