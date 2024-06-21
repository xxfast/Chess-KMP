package io.github.xxfast.chess.screens.settings

import io.github.xxfast.chess.discover.Player
import kotlinx.serialization.Serializable

val Loading = null

@Serializable
data class SettingsState(
  val player: Player? = Loading
)

sealed interface SettingsEvent {
  data class UpdateUsername(val username: String) : SettingsEvent
}
