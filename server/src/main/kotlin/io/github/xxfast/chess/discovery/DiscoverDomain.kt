package io.github.xxfast.chess.discovery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.github.xxfast.chess.game.PieceColor
import io.github.xxfast.chess.game.globalMatches
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.map
import kotlin.time.Duration.Companion.minutes

private val globalQueue: MutableStateFlow<List<Player>> = MutableStateFlow(emptyList())
private val globalInvites: MutableStateFlow<Set<Invite>> = MutableStateFlow(emptySet())

@Composable
fun DiscoverDomain(player: Player, events: SharedFlow<DiscoveryEvent>): DiscoveryState {
  val players: List<Player> by globalQueue.collectAsState()

  val matches: Set<Match>? by globalMatches
    .map { matches -> matches.filter { match -> player in match.scores.map { it.player } } }
    .map { it.toSet() }
    .collectAsState(Loading)

  val invites: Set<Invite>? by globalInvites
    .map { invites -> invites.filter { invite -> invite.from == player || invite.to == player } }
    .map { it.toSet() }
    .collectAsState(Loading)

  // List the player in the global queue
  DisposableEffect(player) {
    globalQueue.value += player
    onDispose {
      globalQueue.value -= player
      // Remove any invites from that player if they exist
      globalInvites.value = globalInvites.value
        .filter { invite -> invite.from != player && invite.to != player }
        .toSet()
    }
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

        is DiscoveryEvent.Accept -> {
          // Remove the invite from the global invites
          globalInvites.value = updatedInvites
            .filter { invite -> invite != event.invite }
            .toSet()

          // Create a game in the global games
          val match = Match(
            scores = listOf(
              PlayerScore(event.invite.from, PieceColor.White, 0, 10.minutes),
              PlayerScore(event.invite.to, PieceColor.Black, 0, 10.minutes),
            ),
          )
          globalMatches.value += match
        }

        is DiscoveryEvent.Withdraw -> globalInvites.value = updatedInvites
          .filter { invite -> invite != event.invite }
          .toSet()
      }
    }
  }

  return DiscoveryState(
    players = players,
    invites = invites,
    matches = matches
  )
}
