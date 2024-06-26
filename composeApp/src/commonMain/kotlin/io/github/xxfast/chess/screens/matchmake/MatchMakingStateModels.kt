package io.github.xxfast.chess.screens.matchmake

import io.github.xxfast.chess.matchmaking.Invite
import io.github.xxfast.chess.matchmaking.Player
import kotlin.time.Duration.Companion.seconds

val Loading = null

val REDIRECT_DURATION = 5.seconds

data class MatchMakingState(
  val player: Player? = Loading,
  val isOnline: Boolean? = Loading,
  val players: List<Player>? = Loading,
  val invites: Set<Invite>? = Loading,
)
