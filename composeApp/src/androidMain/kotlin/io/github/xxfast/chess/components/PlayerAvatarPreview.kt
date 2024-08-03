package io.github.xxfast.chess.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.xxfast.chess.discovery.Player

@Preview
@Composable
fun PreviewPlayerAvatar() {
  PlayerAvatar(
    player = Player(
      name = "isuru",
      elo = 42,
    )
  )
}