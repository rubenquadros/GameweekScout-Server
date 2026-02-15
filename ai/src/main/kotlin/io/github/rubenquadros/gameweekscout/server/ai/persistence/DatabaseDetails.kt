package io.github.rubenquadros.gameweekscout.server.ai.persistence

import java.io.File
import java.util.Properties

data class DatabaseDetails(
    val url: String,
    val adminAccessPath: String
) {
    companion object {
        fun default() = DatabaseDetails(
            url = System.getenv("DATABASE_URL"),
            adminAccessPath = "etc/secrets/admin.json"
        )
    }
}

fun getDatabaseDetails(): DatabaseDetails {
    return runCatching {
        val properties = Properties().apply {
            File("/Users/rquadros/Documents/Ruben/git_tree/GameWeekScout-Server/local.properties")
                .inputStream()
                .use { load(it) }
        }

        DatabaseDetails(
            url = properties.getProperty("dbUrl"),
            adminAccessPath = properties.getProperty("adminAccountPath")
        )
    }.getOrElse {
        DatabaseDetails.default()
    }
}
