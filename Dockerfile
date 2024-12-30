FROM gradle:8.12.0-jdk21-alpine AS builder
WORKDIR /app

COPY gradle/ gradle/
COPY build.gradle.kts settings.gradle.kts gradlew ./
RUN gradle dependencies --no-daemon

COPY src/ src/
RUN gradle installDist --no-daemon

FROM bellsoft/liberica-openjre-alpine:21.0.5
WORKDIR /app
COPY --from=builder /app/build/install/ktor /app
ENTRYPOINT ["/app/bin/ktor"]
