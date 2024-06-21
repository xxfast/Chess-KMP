package io.github.xxfast.chess.discover

import app.cash.molecule.RecompositionMode.Immediate
import app.cash.molecule.launchMolecule
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.rpc.internal.ExperimentalRPCApi
import kotlinx.rpc.internal.invokeOnStreamScopeCompletion
import kotlin.coroutines.CoroutineContext

@OptIn(ExperimentalRPCApi::class)
class DiscoverService(override val coroutineContext: CoroutineContext) : DiscoverApi {

  override suspend fun discover(player: Player): Flow<List<Player>> {
    invokeOnStreamScopeCompletion { coroutineContext.cancel() }
    return launchMolecule(Immediate) { DiscoverDomain(player) }
  }
}
