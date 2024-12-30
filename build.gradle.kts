plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.logback)

    implementation(libs.ktor.serialization)
    implementation(libs.ktor.server)
    implementation(libs.ktor.server.content.negation)
}

kotlin {
    jvmToolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    applicationName = "ktor"
    mainClass = "org.example.AppKt"
}
