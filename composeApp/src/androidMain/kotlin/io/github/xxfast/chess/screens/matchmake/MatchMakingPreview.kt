package io.github.xxfast.chess.screens.matchmake

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import io.github.xxfast.chess.discover.Player
import io.github.xxfast.chess.resources.ChessTheme

val PREVIEW_PLAYER = Player(
  id = "player1",
  elo = 100,
  name = "xxfast",
)

private val LOCALHOST = ServerState(
  name = "localhost",
  address = Address("localhost:8080"),
  isOnline = true,
  players = listOf(
    Player("player2", 110, "opponent1"),
    Player("player3", 120, "opponent2"),
  ),
)

@Preview(wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE, apiLevel = 31)
@Composable
fun MatchMakingOnlinePreview() {
  ChessTheme {
    Surface {
      MatchMakingView(
        state = MatchMakingState(
          player = PREVIEW_PLAYER,
          server = null,
        ),
        onJoin = { _, _ -> },
        onMatch = { },
        onLeave = { },
        onSettings = { },
      )
    }
  }
}

@Preview
@Composable
fun MatchMakingOfflinePreview() {
  ChessTheme {
    Surface {
      MatchMakingView(
        state = MatchMakingState(
          player = PREVIEW_PLAYER,
          server = LOCALHOST,
        ),
        onJoin = { _, _ -> },
        onMatch = { },
        onLeave = { },
        onSettings = { },
      )
    }
  }
}

@Preview(wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE, apiLevel = 31)
@Composable
fun MatchMakingJoinedPreview() {
  ChessTheme {
    Surface {
      MatchMakingView(
        state = MatchMakingState(
          player = PREVIEW_PLAYER,
          server = LOCALHOST
        ),
        onJoin = { _, _ -> },
        onMatch = { },
        onLeave = { },
        onSettings = { },
      )
    }
  }
}
