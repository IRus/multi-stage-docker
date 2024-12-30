package org.example

import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.install
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.serialization.Serializable

fun main() {
    embeddedServer(CIO, port = 8080) {
        install(ContentNegotiation) {
            json()
        }

        routing {
            get("/healthcheck") {
                call.respond(HttpStatusCode.OK, HealthCheckResponse("OK", "All good!"))
            }
        }
    }.start(wait = true)
}

@Serializable
data class HealthCheckResponse(
    val status: String,
    val message: String,
)