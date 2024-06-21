package io.github.xxfast.chess.screens.matchmake

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.benasher44.uuid.uuid4
import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.chess.api.HttpClient
import io.github.xxfast.chess.discover.DiscoverApi
import io.github.xxfast.chess.discover.Player
import io.github.xxfast.chess.screens.matchmake.MatchMakingEvent.Join
import io.github.xxfast.chess.screens.matchmake.MatchMakingEvent.Leave
import io.github.xxfast.chess.screens.matchmake.MatchMakingEvent.Match
import io.github.xxfast.chess.screens.settings.Loading
import io.github.xxfast.chess.utils.Device
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
import kotlin.jvm.JvmInline
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

val UserPlayer = Player(
  id = uuid4().toString(),
  elo = Random.nextInt(100, 200),
  name = "xxfast@${Device.model}"
)

@JvmInline
value class Address(val value: String) : CharSequence by value {
  constructor(host: String, port: Int) : this("$host:$port")
  val host: String get() = value.substringBefore(":")
  val port: Int get() = value.substringAfter(":").toInt()
}

data class Server(
  val address: Address,
  val client: RPCClient? = null,
  val session: Job? = null,
)

@Composable
fun ChessApplicationScope.MatchMakingDomain(events: SharedFlow<MatchMakingEvent>): MatchMakingState {
  var server: Server? by remember { mutableStateOf(null) }
  var opponents: List<Player>? by remember { mutableStateOf(emptyList()) }
  val player: Player? by userStore.updates.collectAsState(Loading)

  LaunchedEffect(server) {
    val address: Address = server?.address ?: return@LaunchedEffect
    if (server?.client != null) return@LaunchedEffect
    do {
      server = server?.copy(
        client = try {
          HttpClient
            .rpc {
              url("ws://${address.value}/discover")
              rpcConfig { serialization { json() } }
            }
        } catch (e: Exception) {
          null
        },
      )

      // Retry all failed servers after 5 seconds
      delay(5.seconds)
    } while (server?.client == null)
  }

  LaunchedEffect(server?.client, player) {
    val client: RPCClient = server?.client ?: return@LaunchedEffect
    val user: Player = player ?: return@LaunchedEffect
    server = server?.copy(
      session = launch {
        streamScoped {
          client
            .withService<DiscoverApi>()
            .discover(user)
            .collect { players ->
              opponents = players
            }
        }
      }
    )
  }

  LaunchedEffect(Unit) {
    events.collect { event ->
      when (event) {
        is Join -> server = Server(Address(event.host, event.port))
        is Leave -> server = null
        is Match -> TODO()
      }
    }
  }

  return MatchMakingState(
    player = player,
    server = server?.let {
      ServerState(
        name = it.address.host,
        address = it.address,
        isOnline = it.client != null,
        players = opponents,
      )
    }
  )
}
