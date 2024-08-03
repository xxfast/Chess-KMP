package io.github.xxfast.chess.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.xxfast.chess.discovery.Match
import io.github.xxfast.chess.discovery.MatchId

@Composable
fun MatchSummaryView(
  match: Match,
  onGame: (MatchId) -> Unit,
  modifier: Modifier = Modifier,
) {
  Card(
    onClick = { onGame(match.id) },
    colors = CardDefaults.elevatedCardColors(
      containerColor = MaterialTheme.colorScheme.primaryContainer,
      contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
    ),
    modifier = modifier
      .width(256.dp)
  ) {
    Column(
      modifier = Modifier
        .padding(16.dp)
    ) {
      GameBoard(
        game = match.game,
        isCompact = true,
        modifier = Modifier
          .clip(MaterialTheme.shapes.medium)
      )

      Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        Row(
          horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          match.scores.forEach { (player) ->
              PlayerAvatar(player)
          }
        }

        val (playerScore, opponentScore) = match.scores

        Text(
          text = "${playerScore.player.name} v. ${opponentScore.player.name}",
          style = MaterialTheme.typography.bodyMedium,
          fontWeight = FontWeight.Bold,
        )
      }
    }
  }
}