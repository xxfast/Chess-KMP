package io.github.xxfast.chess.screens.matchmake

import io.github.xxfast.chess.discover.Player

val Loading = null
val None = null

data class MatchMakingState(
  val player: Player? = Loading,
  val server: ServerState? = None,
)

data class ServerState(
  val name: String,
  val address: Address,
  val isOnline: Boolean,
  val players: List<Player>?,
)

sealed interface MatchMakingEvent {
  data class Join(val host: String, val port: Int) : MatchMakingEvent
  data class Leave(val address: Address) : MatchMakingEvent
  data class Match(val player: Player) : MatchMakingEvent
}
