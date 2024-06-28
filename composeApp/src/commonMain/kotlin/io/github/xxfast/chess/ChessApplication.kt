package io.github.xxfast.chess

import io.github.xxfast.chess.discovery.Player
import io.github.xxfast.chess.discovery.Address
import io.github.xxfast.chess.utils.storeOf
import io.github.xxfast.kstore.KStore
import kotlinx.serialization.json.Json

// TODO: Use context receivers once available for multiplatform
interface ChessApplicationScope {
  val platform: PlatformScope
  val json: Json
  val userStore: KStore<Player>
  val serverStore: KStore<Address>
}

class ChessApplication(override val platform: PlatformScope) : ChessApplicationScope {
  override lateinit var json: Json
  override lateinit var userStore: KStore<Player>
  override lateinit var serverStore: KStore<Address>
}

expect class PlatformScope

fun PlatformScope.ChessApplication(builder: ChessApplication.() -> Unit): ChessApplication =
  ChessApplication(this)
    .apply(builder)

val PlatformScope.ChessApplication get() = ChessApplication {
  json = Json {
    ignoreUnknownKeys = true
    encodeDefaults = true
    allowStructuredMapKeys = true
  }

  userStore = storeOf(name = "player", default = Player())
  serverStore = storeOf(name = "server", default = Address("10.0.2.2", 8080))
}

