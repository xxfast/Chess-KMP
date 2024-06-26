package io.github.xxfast.chess.screens.matchmake

import app.cash.molecule.launchMolecule
import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.chess.matchmaking.DiscoveryEvent
import io.github.xxfast.chess.matchmaking.Invite
import io.github.xxfast.chess.matchmaking.Player
import io.github.xxfast.chess.utils.Default
import io.github.xxfast.chess.utils.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MatchMakingViewModel(scope: ChessApplicationScope) : ViewModel() {
  private val events: MutableSharedFlow<DiscoveryEvent> = MutableSharedFlow()

  val state: StateFlow<MatchMakingState> = launchMolecule(Default) {
    with(scope) { MatchMakingDomain(events) }
  }

  fun onInvite(from: Player, to: Player) { launch { events.emit(DiscoveryEvent.Send(from, to)) } }
  fun onDecline(invite: Invite) { launch { events.emit(DiscoveryEvent.Decline(invite)) } }
  fun onAccept(invite: Invite) { launch { events.emit(DiscoveryEvent.Accept(invite)) } }
  fun onWithdraw(invite: Invite) { launch { events.emit(DiscoveryEvent.Withdraw(invite)) } }
}
