package io.github.xxfast.chess.screens.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.chess.discover.Player
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun ChessApplicationScope.SettingsDomain(
  events: SharedFlow<SettingsEvent>
): SettingsState {
  val user: Player? by userStore.updates.collectAsState(Loading)

  LaunchedEffect(Unit) {
    events.collect { event ->
      when (event) {
        is SettingsEvent.UpdateUsername -> {
          userStore.update { user ->
            user?.copy(name = event.username)
          }
        }
      }
    }
  }

  return SettingsState(
    player = user
  )
}
