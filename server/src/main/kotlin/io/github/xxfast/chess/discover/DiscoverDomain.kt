package io.github.xxfast.chess.discover

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import kotlinx.coroutines.flow.MutableStateFlow

private val globalQueue: MutableStateFlow<List<Player>> = MutableStateFlow(emptyList())

@Composable
fun DiscoverDomain(player: Player): List<Player> {
  val players: List<Player> by globalQueue.collectAsState()

  // List the player in the global queue
  DisposableEffect(player) {
    globalQueue.value += player
    onDispose { globalQueue.value -= player }
  }

  return players
}
