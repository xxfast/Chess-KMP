package io.github.xxfast.chess.game

import io.github.xxfast.chess.discovery.Match
import io.github.xxfast.chess.discovery.MatchId
import io.github.xxfast.chess.discovery.Player
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.rpc.RPC

interface GameApi : RPC {
  suspend fun match(id: MatchId, player: Player, events: SharedFlow<GameEvent>): Flow<Match>
}