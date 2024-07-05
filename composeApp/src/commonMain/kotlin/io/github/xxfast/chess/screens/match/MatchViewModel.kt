package io.github.xxfast.chess.screens.match

import app.cash.molecule.moleculeFlow
import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.chess.discovery.MatchId
import io.github.xxfast.chess.game.GameEvent
import io.github.xxfast.chess.game.Move
import io.github.xxfast.chess.utils.Default
import io.github.xxfast.chess.utils.ViewModel
import io.github.xxfast.decompose.router.RouterContext
import io.github.xxfast.decompose.router.state
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MatchViewModel(
  routerContext: RouterContext,
  scope: ChessApplicationScope,
  id: MatchId,
) : ViewModel() {
  private val events: MutableSharedFlow<GameEvent> = MutableSharedFlow()
  private val initialState: MatchState = routerContext.state(MatchState()) { state.value }
  val state: StateFlow<MatchState> = moleculeFlow(Default) { with(scope) { GameDomain(id, events) } }
    .stateIn(this, SharingStarted.Lazily, initialState)

  fun onMove(move: Move) { launch { events.emit(GameEvent.MakeMove(move)) } }
}