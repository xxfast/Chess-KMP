package io.github.xxfast.chess.discover

import kotlinx.coroutines.flow.Flow
import kotlinx.rpc.RPC

interface DiscoverApi : RPC {
  suspend fun discover(player: Player): Flow<List<Player>>
}
