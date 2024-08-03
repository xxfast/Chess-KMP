package io.github.xxfast.chess.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Badge
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.xxfast.chess.discovery.Player

@Composable
fun PlayerTitle(
  player: Player,
) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(4.dp)
  ) {
    Text(
      text = player.name,
      style = MaterialTheme.typography.bodyLarge,
    )

    Badge {
      Text(
        text = "${player.elo}",
        style = MaterialTheme.typography.bodyMedium,
        color = LocalContentColor.current,
        fontWeight = FontWeight.ExtraBold
      )
    }
  }
}