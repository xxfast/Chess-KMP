package io.github.xxfast.chess.screens.match

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import io.github.xxfast.chess.discovery.PlayerScore
import io.github.xxfast.chess.game.Game
import io.github.xxfast.chess.game.PieceColor
import io.github.xxfast.chess.game.Standard
import io.github.xxfast.chess.game.legalMoves
import io.github.xxfast.chess.resources.ChessTheme
import io.github.xxfast.chess.screens.matchmake.PREVIEW_PLAYER_1
import io.github.xxfast.chess.screens.matchmake.PREVIEW_PLAYER_2
import kotlin.time.Duration.Companion.minutes

@Preview
@Preview(device = Devices.FOLDABLE)
@Composable
fun MatchPreview() {
  ChessTheme {
    Surface {
      MatchView(
        state = MatchState(
          userScore = PlayerScore(PREVIEW_PLAYER_1, PieceColor.White, 0, 10.minutes),
          opponentScore = PlayerScore(PREVIEW_PLAYER_2, PieceColor.Black, 0, 10.minutes),
          game = Game(
            board = Standard,
            turn = PieceColor.White,
            moves = legalMoves(Standard, PieceColor.White),
            history = List(100) { "#$it" }
          ),
        ),
        onMove = {},
        onClose = {},
      )
    }
  }
}