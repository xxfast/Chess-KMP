package io.github.xxfast.chess.screens.matchmake

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.chess.api.HttpClient
import io.github.xxfast.chess.matchmaking.Address
import io.github.xxfast.chess.matchmaking.DiscoveryEvent
import io.github.xxfast.chess.matchmaking.DiscoveryState
import io.github.xxfast.chess.matchmaking.DiscoveryApi
import io.github.xxfast.chess.matchmaking.Player
import io.github.xxfast.chess.screens.settings.Loading
import io.ktor.client.request.url
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlinx.rpc.RPCClient
import kotlinx.rpc.client.withService
import kotlinx.rpc.internal.streamScoped
import kotlinx.rpc.serialization.json
import kotlinx.rpc.transport.ktor.client.rpc
import kotlinx.rpc.transport.ktor.client.rpcConfig
import kotlin.time.Duration.Companion.seconds

@Composable
fun ChessApplicationScope.MatchMakingDomain(events: SharedFlow<DiscoveryEvent>): MatchMakingState {
  val address: Address? by serverStore.updates.collectAsState(Loading)
  var client: RPCClient? by remember { mutableStateOf(null) }
  var session: Job? by remember { mutableStateOf(null) }

  var discovery: DiscoveryState? by remember { mutableStateOf(Loading) }

  val player: Player? by userStore.updates.collectAsState(Loading)

  LaunchedEffect(address) {
    val server: Address = address ?: return@LaunchedEffect

    // Cancel any previous sessions
    session?.cancel()
    discovery = Loading

    do {
      client = try {
        HttpClient
          .rpc {
            url("ws://${server.value}/discover")
            rpcConfig {   serialization { json() } }
          }
      } catch (e: Exception) {
        null
      }

      // Retry all failed servers after 5 seconds
      delay(5.seconds)
    } while (client == null)
  }

  LaunchedEffect(client, player) {
    val client: RPCClient = client ?: return@LaunchedEffect
    val user: Player = player ?: return@LaunchedEffect
    session?.cancel()
    session = launch {
      streamScoped {
        client
          .withService<DiscoveryApi>()
          .discover(user, events)
          .collect { players ->
            discovery = players
          }
      }
    }
  }

  return MatchMakingState(
    player = player,
    isOnline = client != null,
    players = discovery?.players,
    invites = discovery?.invites
  )
}
