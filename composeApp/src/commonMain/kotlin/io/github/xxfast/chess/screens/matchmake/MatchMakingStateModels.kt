package io.github.xxfast.chess.screens.matchmake

import io.github.xxfast.chess.discovery.Invite
import io.github.xxfast.chess.discovery.Player
import kotlin.time.Duration.Companion.seconds

val Loading = null

data class MatchMakingState(
  val player: Player? = Loading,
  val isOnline: Boolean? = Loading,
  val players: List<Player>? = Loading,
  val invites: Set<Invite>? = Loading,
)
