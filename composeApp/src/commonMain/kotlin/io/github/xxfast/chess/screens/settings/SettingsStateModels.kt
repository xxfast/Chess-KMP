package io.github.xxfast.chess.screens.settings

import io.github.xxfast.chess.discovery.Player
import io.github.xxfast.chess.discovery.Address
import io.github.xxfast.chess.game.Piece
import kotlinx.serialization.Serializable

val Loading = null

@Serializable
data class SettingsState(
  val player: Player? = Loading,
  val serverAddress: Address? = Loading,
)

sealed interface SettingsEvent {
  data class UpdateUsername(val username: String) : SettingsEvent
  data class UpdateServer(val address: Address) : SettingsEvent
  data class UpdateAvatar(val piece: Piece) : SettingsEvent
}
