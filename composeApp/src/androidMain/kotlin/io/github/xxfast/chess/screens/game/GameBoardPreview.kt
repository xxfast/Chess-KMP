package io.github.xxfast.chess.screens.game

import android.content.res.Configuration
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import io.github.xxfast.chess.resources.ChessTheme

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
        state = GameState(),
        onMove = { _ -> }
      )
    }
  }
}


