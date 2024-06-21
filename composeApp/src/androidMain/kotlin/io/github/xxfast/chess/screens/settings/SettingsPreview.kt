package io.github.xxfast.chess.screens.settings

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.xxfast.chess.resources.ChessTheme
import io.github.xxfast.chess.screens.matchmake.PREVIEW_PLAYER

@Preview
@Composable
fun SettingsPreview() {
  ChessTheme {
    SettingsView(
      state = SettingsState(
        player = PREVIEW_PLAYER,
      ),
      onBack = { },
      onUpdateUsername = {  },
    )
  }
}
