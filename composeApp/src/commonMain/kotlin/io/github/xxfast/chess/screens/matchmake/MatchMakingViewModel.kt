package io.github.xxfast.chess.screens.matchmake

import app.cash.molecule.launchMolecule
import io.github.xxfast.chess.discover.Player
import io.github.xxfast.chess.utils.Default
import io.github.xxfast.chess.utils.ViewModel
import io.ktor.util.network.NetworkAddress
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MatchMakingViewModel : ViewModel() {
  private val events: MutableSharedFlow<MatchMakingEvent> = MutableSharedFlow()

  val state: StateFlow<MatchMakingState> = launchMolecule(Default) { MatchMakingDomain(events) }

  fun onJoin(address: String, port: Int) { launch { events.emit(MatchMakingEvent.Join(address, port)) } }
  fun onLeave(server: ServerState) { launch { events.emit(MatchMakingEvent.Leave(server.address)) } }
  fun onMatch(player: Player) { launch { events.emit(MatchMakingEvent.Match(player)) } }
}
