package io.github.xxfast.chess.components

import android.content.res.Configuration
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import io.github.xxfast.chess.discovery.Match
import io.github.xxfast.chess.game.Game
import io.github.xxfast.chess.game.PieceColor
import io.github.xxfast.chess.game.Standard
import io.github.xxfast.chess.game.legalMoves
import io.github.xxfast.chess.resources.ChessTheme
import io.github.xxfast.chess.screens.match.MatchState
import io.github.xxfast.chess.screens.match.MatchView
import io.github.xxfast.chess.screens.matchmake.PREVIEW_PLAYER_1
import io.github.xxfast.chess.screens.matchmake.PREVIEW_PLAYER_2

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(
  uiMode = Configuration.UI_MODE_NIGHT_YES, wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
  apiLevel = 31
)
@Preview(wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE, apiLevel = 31)
@Composable
fun GameBoardPreview() {
  ChessTheme {
    Surface {
      GameBoard(
        game = Game(),
        onMove = { _ -> }
      )
    }
  }
}


