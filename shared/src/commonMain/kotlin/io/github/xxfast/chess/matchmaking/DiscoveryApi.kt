package io.github.xxfast.chess.matchmaking

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.rpc.RPC

interface DiscoveryApi : RPC {
  suspend fun discover(player: Player, events: SharedFlow<DiscoveryEvent>): Flow<DiscoveryState>
}
