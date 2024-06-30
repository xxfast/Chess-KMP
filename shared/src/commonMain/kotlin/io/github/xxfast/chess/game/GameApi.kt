package io.github.xxfast.chess.game

import io.github.xxfast.chess.discovery.Match
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.rpc.RPC

interface GameApi : RPC {
  suspend fun match(id: String, events: SharedFlow<GameEvent>): Flow<Match>
}