package io.github.xxfast.chess

import SERVER_PORT
import io.github.xxfast.chess.matchmaking.DiscoveryApi
import io.github.xxfast.chess.discovery.DiscoveryService
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.WebSockets
import kotlinx.rpc.serialization.json
import kotlinx.rpc.transport.ktor.server.rpc

fun main() {
  embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
    .start(wait = true)
}

fun Application.module() {
  install(WebSockets)

  routing {
    get("/") {
      call.respondText("ChessKMP")
    }

    rpc("/game") {
      rpcConfig { serialization { json() } }
    }

    rpc("/discover") {
      rpcConfig { serialization { json() } }
      registerService<DiscoveryApi> { DiscoveryService(coroutineContext) }
    }
  }
}
