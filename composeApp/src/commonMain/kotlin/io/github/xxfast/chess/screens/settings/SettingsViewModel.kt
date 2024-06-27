package io.github.xxfast.chess.screens.settings

import app.cash.molecule.moleculeFlow
import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.chess.discovery.Address
import io.github.xxfast.chess.utils.Default
import io.github.xxfast.chess.utils.ViewModel
import io.github.xxfast.decompose.router.RouterContext
import io.github.xxfast.decompose.router.state
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(
  scope: ChessApplicationScope,
  routerContext: RouterContext,
) : ViewModel() {
  private val events: MutableSharedFlow<SettingsEvent> = MutableSharedFlow()
  private val initialState: SettingsState = routerContext.state(SettingsState()) { state.value }
  val state: StateFlow<SettingsState> =
    moleculeFlow(Default) { with(scope) { SettingsDomain(events) } }
      .stateIn(this, SharingStarted.Lazily, initialState)

  fun onUpdateUsername(username: String) {
    launch { events.emit(SettingsEvent.UpdateUsername(username)) }
  }

  fun onUpdateAddress(address: Address) {
    launch { events.emit(SettingsEvent.UpdateServer(address)) }
  }
}
