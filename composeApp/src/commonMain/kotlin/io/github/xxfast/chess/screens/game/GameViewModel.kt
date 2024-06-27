package io.github.xxfast.chess.screens.game

import app.cash.molecule.moleculeFlow
import io.github.xxfast.chess.game.GameEvent
import io.github.xxfast.chess.game.GameState
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

class GameViewModel(routerContext: RouterContext) : ViewModel() {
  private val events: MutableSharedFlow<GameEvent> = MutableSharedFlow()
  private val initialState: GameState = routerContext.state(GameState()) { state.value }
  val state: StateFlow<GameState> = moleculeFlow(Default) { GameDomain(events) }
    .stateIn(this, SharingStarted.Lazily, initialState)

  fun onMove(move: Move) { launch { events.emit(GameEvent.MakeMove(move)) } }
}