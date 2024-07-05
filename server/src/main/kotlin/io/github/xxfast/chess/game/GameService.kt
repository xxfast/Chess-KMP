package io.github.xxfast.chess.game

import app.cash.molecule.RecompositionMode.Immediate
import app.cash.molecule.launchMolecule
import io.github.xxfast.chess.discovery.Match
import io.github.xxfast.chess.discovery.MatchId
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.rpc.internal.ExperimentalRPCApi
import kotlinx.rpc.internal.invokeOnStreamScopeCompletion
import kotlin.coroutines.CoroutineContext

class GameService(override val coroutineContext: CoroutineContext) : GameApi {
  @OptIn(ExperimentalRPCApi::class)
  override suspend fun match(id: MatchId, events: SharedFlow<GameEvent>): Flow<Match> {
    invokeOnStreamScopeCompletion { coroutineContext.cancel() }
    return launchMolecule(Immediate) { GameDomain(id, events) }
  }
}