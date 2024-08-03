package io.github.xxfast.chess.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.xxfast.chess.discovery.Match
import io.github.xxfast.chess.discovery.MatchId
import io.github.xxfast.chess.discovery.PlayerScore
import io.github.xxfast.chess.game.Game
import io.github.xxfast.chess.game.PieceColor
import io.github.xxfast.chess.resources.ChessTheme
import io.github.xxfast.chess.screens.matchmake.PREVIEW_PLAYER_1
import io.github.xxfast.chess.screens.matchmake.PREVIEW_PLAYER_2
import kotlin.time.Duration.Companion.minutes

@Preview
@Composable
private fun MatchSummaryPreview() {
  ChessTheme {
    MatchSummaryView(
      match = Match(
        id = MatchId("1"),
        game = Game(),
        scores = listOf(
          PlayerScore(PREVIEW_PLAYER_1, PieceColor.White, 0, 10.minutes),
          PlayerScore(PREVIEW_PLAYER_2, PieceColor.Black, 0, 10.minutes),
        )
      ),
      onGame = {})
  }
}