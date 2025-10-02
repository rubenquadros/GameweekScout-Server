plugins {
    alias(libs.plugins.org.jetbrains.kotlin.jvm)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.ksp)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.ktor.client)

    implementation(libs.bundles.koin)
    implementation(libs.koin.annotation)
    ksp(libs.koin.ksp)

    implementation(libs.coroutines.jvm)

    testImplementation(libs.koin.test)
    testImplementation(libs.kotlin.test)
    testImplementation(libs.coroutines.test)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}