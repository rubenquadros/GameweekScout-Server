package io.github.rubenquadros.gameweekscout.server.ai.di

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import io.github.rubenquadros.gameweekscout.server.ai.ScoutService
import io.github.rubenquadros.gameweekscout.server.ai.ScoutServiceImpl
import io.github.rubenquadros.gameweekscout.server.ai.persistence.FirestorePersistenceProvider
import io.github.rubenquadros.gameweekscout.server.ai.persistence.getDatabaseDetails
import io.github.rubenquadros.gameweekscout.server.fpl.FplApi
import io.github.rubenquadros.gameweekscout.server.fpl.di.FplModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.FileInputStream

@Module(includes = [FplModule::class])
@ComponentScan("io.github.rubenquadros.gameweekscout.server.ai")
class AiModule {

    @Single
    fun provideScoutService(fplApi: FplApi, persistence: FirestorePersistenceProvider): ScoutService {
        return ScoutServiceImpl(fplApi = fplApi, persistence = persistence)
    }

    @Factory
    fun provideFireStore(): Firestore {
        val databaseDetails = getDatabaseDetails()
        val firebaseOptions = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(FileInputStream(databaseDetails.adminAccessPath)))
            .setDatabaseUrl(databaseDetails.url)
            .build()

        val app = FirebaseApp.initializeApp(firebaseOptions)

        return FirestoreClient.getFirestore(app)
    }
}