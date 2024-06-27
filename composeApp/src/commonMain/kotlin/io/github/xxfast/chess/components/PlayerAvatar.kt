package io.github.xxfast.chess.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.xxfast.chess.discovery.Player
import io.github.xxfast.chess.resources.pieces.Pieces
import io.github.xxfast.chess.resources.pieces.pieces.Regular
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wn
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PlayerAvatar(
  player: Player,
  icon: @Composable () -> Unit = {
    Image(
      imageVector = Pieces.Regular.Wn,
      contentDescription = null,
      modifier = Modifier
        .size(48.dp)
    )
  },
) {
  Column(
    verticalArrangement = Arrangement.spacedBy(4.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    icon()

    Text(
      text = "${player.elo}",
      style = MaterialTheme.typography.bodyMedium,
      color = MaterialTheme.colorScheme.primary,
      fontWeight = FontWeight.ExtraBold
    )
  }
}

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
