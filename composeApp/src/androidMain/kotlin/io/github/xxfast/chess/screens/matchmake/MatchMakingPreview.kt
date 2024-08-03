package io.github.xxfast.chess.screens.matchmake

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import io.github.xxfast.chess.discovery.Invite
import io.github.xxfast.chess.discovery.InviteStatus
import io.github.xxfast.chess.discovery.Match
import io.github.xxfast.chess.discovery.MatchId
import io.github.xxfast.chess.discovery.Player
import io.github.xxfast.chess.discovery.PlayerScore
import io.github.xxfast.chess.game.Game
import io.github.xxfast.chess.game.PieceColor
import io.github.xxfast.chess.resources.ChessTheme
import kotlin.time.Duration.Companion.minutes

val PREVIEW_PLAYER_1 = Player(
  id = "player1",
  elo = 100,
  name = "xxfast",
)

val PREVIEW_PLAYER_2 = Player(
  id = "player2",
  elo = 100,
  name = "isuru",
)

@Preview(wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE, apiLevel = 31)
@Composable
fun MatchMakingOnlinePreview() {
  ChessTheme {
    Surface {
      MatchMakingView(
        state = MatchMakingState(
          player = PREVIEW_PLAYER_1,
          isOnline = true,
          players = listOf(PREVIEW_PLAYER_1),
          invites = setOf(
            Invite(PREVIEW_PLAYER_1, PREVIEW_PLAYER_2, InviteStatus.SENT),
            Invite(PREVIEW_PLAYER_2, PREVIEW_PLAYER_1, InviteStatus.SENT),
            Invite(PREVIEW_PLAYER_2, PREVIEW_PLAYER_2, InviteStatus.REJECTED),
          ),
          matches = setOf(
            Match(
              id = MatchId(),
              game = Game(),
              scores = listOf(
                PlayerScore(PREVIEW_PLAYER_1, PieceColor.White, 0, 10.minutes),
                PlayerScore(PREVIEW_PLAYER_2, PieceColor.Black, 0, 10.minutes),
              ),
            )
          )
        ),
        onInvite = { _, _ -> },
        onAccept = {},
        onDecline = {},
        onWithdraw = {},
        onSettings = {},
        onGame = {},
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
          player = PREVIEW_PLAYER_1, isOnline = false
        ),
        onInvite = { _, _ -> },
        onAccept = {},
        onDecline = {},
        onWithdraw = {},
        onSettings = {},
        onGame = {},
      )
    }
  }
}

@Preview(wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE, apiLevel = 31)
@Composable
fun MatchMakingEmptyPreview() {
  ChessTheme {
    Surface {
      MatchMakingView(
        state = MatchMakingState(
          player = PREVIEW_PLAYER_1, isOnline = true, players = emptyList()
        ),
        onInvite = { _, _ -> },
        onAccept = {},
        onDecline = {},
        onWithdraw = {},
        onSettings = {},
        onGame = {},
      )
    }
  }
}
