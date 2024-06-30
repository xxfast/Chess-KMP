package io.github.xxfast.chess.screens.game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.chess.api.HttpClient
import io.github.xxfast.chess.discovery.Address
import io.github.xxfast.chess.discovery.Match
import io.github.xxfast.chess.game.GameApi
import io.github.xxfast.chess.game.GameEvent
import io.github.xxfast.chess.game.Game
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
fun ChessApplicationScope.GameDomain(match: Match, events: SharedFlow<GameEvent>): GameState {
  val address: Address? by serverStore.updates.collectAsState(Loading)
  var client: RPCClient? by remember { mutableStateOf(null) }
  var session: Job? by remember { mutableStateOf(null) }

  var game: Game? by remember { mutableStateOf(Loading) }

  LaunchedEffect(address) {
    val server: Address = address ?: return@LaunchedEffect
    // Cancel any previous sessions
    session?.cancel()
    game = Loading

    do {
      client = try {
        HttpClient
          .rpc {
            url("ws://${server.value}/game")
            rpcConfig {   serialization { json() } }
          }
      } catch (e: Exception) {
        null
      }

      // Retry all failed servers after 5 seconds
      delay(5.seconds)
    } while (client == null)
  }

  LaunchedEffect(client) {
    val client: RPCClient = client ?: return@LaunchedEffect
    session?.cancel()
    session = launch {
      streamScoped {
        client
          .withService<GameApi>()
          .match(match.id, events)
          .collect { game = it.game }
      }
    }
  }

  return GameState(game)
}