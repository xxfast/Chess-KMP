package io.github.xxfast.chess.discovery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.github.xxfast.chess.matchmaking.DiscoveryEvent
import io.github.xxfast.chess.matchmaking.DiscoveryState
import io.github.xxfast.chess.matchmaking.Invite
import io.github.xxfast.chess.matchmaking.InviteStatus
import io.github.xxfast.chess.matchmaking.Loading
import io.github.xxfast.chess.matchmaking.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.map

private val globalQueue: MutableStateFlow<List<Player>> = MutableStateFlow(emptyList())
private val globalInvites: MutableStateFlow<Set<Invite>> = MutableStateFlow(emptySet())

@Composable
fun DiscoverDomain(player: Player, events: SharedFlow<DiscoveryEvent>): DiscoveryState {
  val players: List<Player> by globalQueue.collectAsState()
  val invites: Set<Invite>? by globalInvites
    .map { invites -> invites.filter { invite -> invite.from == player || invite.to == player } }
    .map { it.toSet() }
    .collectAsState(Loading)

  // List the player in the global queue
  DisposableEffect(player) {
    globalQueue.value += player
    onDispose { globalQueue.value -= player }
  }

  LaunchedEffect(Unit) {
    events.collect { event ->
      // Ignore the event if the invites are loading
      val updatedInvites: Set<Invite> = invites ?: return@collect

      when (event) {
        is DiscoveryEvent.Send ->
          globalInvites.value += Invite(event.from, event.to, InviteStatus.SENT)

        is DiscoveryEvent.Decline -> globalInvites.value = updatedInvites
          .map { invite ->
            if (invite.from == event.invite.from && invite.to == event.invite.to)
              invite.copy(status = InviteStatus.REJECTED)
            else invite
          }
          .toSet()

        is DiscoveryEvent.Accept -> globalInvites.value = updatedInvites
          .map { invite ->
            if (invite.from == event.invite.from && invite.to == event.invite.to)
              invite.copy(status = InviteStatus.ACCEPTED)
            else invite
          }
          .toSet()

        is DiscoveryEvent.Withdraw -> globalInvites.value = updatedInvites
          .filter { invite -> invite != event.invite }
          .toSet()
      }

      println("INVITES $globalInvites")
    }
  }

  return DiscoveryState(
    players = players,
    invites = invites
  )
}
