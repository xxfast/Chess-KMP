package io.github.xxfast.chess.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.rpc.transport.ktor.client.installRPC
import kotlinx.serialization.json.Json

val HttpClient: HttpClient = HttpClient {
  installRPC()

  install(ContentNegotiation) {
    json(
      Json {
        prettyPrint = true
        ignoreUnknownKeys = true
      }
    )
  }

  install(Logging) {
    level = LogLevel.ALL
    logger = Logger.SIMPLE
  }

  expectSuccess = true
}
