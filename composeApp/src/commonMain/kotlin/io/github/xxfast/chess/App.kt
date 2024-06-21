package io.github.xxfast.chess

import androidx.compose.runtime.Composable
import io.github.xxfast.chess.resources.ChessTheme
import io.github.xxfast.chess.screens.game.GameScreen
import io.github.xxfast.chess.screens.matchmake.MatchMakingScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
  ChessTheme {
    MatchMakingScreen()
  }
}
