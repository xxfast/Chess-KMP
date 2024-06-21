package io.github.xxfast.chess

import io.github.xxfast.chess.discover.Player
import io.github.xxfast.chess.utils.storeOf
import io.github.xxfast.kstore.KStore
import kotlinx.serialization.json.Json

interface ChessApplicationScope {
  val platform: PlatformScope
  val json: Json
  val userStore: KStore<Player>
}

class ChessApplication(override val platform: PlatformScope) : ChessApplicationScope {
  override lateinit var json: Json
  override lateinit var userStore: KStore<Player>
}

expect class PlatformScope

fun PlatformScope.ChessApplication(builder: ChessApplication.() -> Unit): ChessApplication =
  ChessApplication(this)
    .apply(builder)

val PlatformScope.ChessApplication get() = ChessApplication {
  json = Json {
    ignoreUnknownKeys = true
    encodeDefaults = true
  }

  userStore = storeOf(name = "player", default = Player())
}

