package io.github.xxfast.chess.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.xxfast.chess.discovery.Player
import io.github.xxfast.chess.screens.match.icon
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PlayerAvatar(
  player: Player,
) {
  Box(
    modifier = Modifier
      .padding(4.dp),
  ) {
    Image(
      imageVector = player.piece.icon,
      contentDescription = null,
      modifier = Modifier
        .size(48.dp)
        .align(Alignment.Center)
    )
  }
}

@Preview
@Composable
fun CommonPreviewPlayerAvatar() {
  PlayerAvatar(
    player = Player(
      name = "isuru",
      elo = 42,
    )
  )
}
