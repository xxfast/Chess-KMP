package io.github.xxfast.chess.discovery

import app.cash.molecule.RecompositionMode.Immediate
import app.cash.molecule.launchMolecule
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.rpc.internal.ExperimentalRPCApi
import kotlinx.rpc.internal.invokeOnStreamScopeCompletion
import kotlin.coroutines.CoroutineContext

@OptIn(ExperimentalRPCApi::class)
class DiscoveryService(override val coroutineContext: CoroutineContext) : DiscoveryApi {
  override suspend fun discover(player: Player, events: SharedFlow<DiscoveryEvent>): Flow<DiscoveryState> {
    invokeOnStreamScopeCompletion { coroutineContext.cancel() }
    return launchMolecule(Immediate) { DiscoverDomain(player, events) }
  }
}
