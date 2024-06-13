package io.github.xxfast.chess.screens.game

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.xxfast.chess.resources.pieces.Pieces
import io.github.xxfast.chess.resources.pieces.pieces.Regular
import io.github.xxfast.chess.resources.pieces.pieces.regular.Bb
import io.github.xxfast.chess.resources.pieces.pieces.regular.Bk
import io.github.xxfast.chess.resources.pieces.pieces.regular.Bn
import io.github.xxfast.chess.resources.pieces.pieces.regular.Bp
import io.github.xxfast.chess.resources.pieces.pieces.regular.Bq
import io.github.xxfast.chess.resources.pieces.pieces.regular.Br
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wb
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wk
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wn
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wp
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wq
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wr
import io.github.xxfast.chess.screens.game.Piece.BB
import io.github.xxfast.chess.screens.game.Piece.BK
import io.github.xxfast.chess.screens.game.Piece.BN
import io.github.xxfast.chess.screens.game.Piece.BP
import io.github.xxfast.chess.screens.game.Piece.BQ
import io.github.xxfast.chess.screens.game.Piece.BR
import io.github.xxfast.chess.screens.game.Piece.WB
import io.github.xxfast.chess.screens.game.Piece.WK
import io.github.xxfast.chess.screens.game.Piece.WN
import io.github.xxfast.chess.screens.game.Piece.WP
import io.github.xxfast.chess.screens.game.Piece.WQ
import io.github.xxfast.chess.screens.game.Piece.WR

enum class Piece {
  WP, WN, WB, WR, WQ, WK,
  BP, BN, BB, BR, BQ, BK,
}

// TODO: Swapping the assets for dark theme for better consistancy
val Piece.icon: ImageVector
  @Composable get() =
    if (isSystemInDarkTheme()) when (this) {
      WP -> Pieces.Regular.Bp
      WN -> Pieces.Regular.Bn
      WB -> Pieces.Regular.Bb
      WR -> Pieces.Regular.Br
      WQ -> Pieces.Regular.Bq
      WK -> Pieces.Regular.Bk
      BP -> Pieces.Regular.Wp
      BN -> Pieces.Regular.Wn
      BB -> Pieces.Regular.Wb
      BR -> Pieces.Regular.Wr
      BQ -> Pieces.Regular.Wq
      BK -> Pieces.Regular.Wk
    } else when (this) {
      WP -> Pieces.Regular.Wp
      WN -> Pieces.Regular.Wn
      WB -> Pieces.Regular.Wb
      WR -> Pieces.Regular.Wr
      WQ -> Pieces.Regular.Wq
      WK -> Pieces.Regular.Wk
      BP -> Pieces.Regular.Bp
      BN -> Pieces.Regular.Bn
      BB -> Pieces.Regular.Bb
      BR -> Pieces.Regular.Br
      BQ -> Pieces.Regular.Bq
      BK -> Pieces.Regular.Bk
    }

typealias Grid<T> = List<List<T?>>

data class GameState(
  val board: Grid<Piece?> = Standard,
)

val Standard: List<List<Piece?>> = List(8) { y ->
  List(8) { x ->
    when (y) {
      1 -> BP
      6 -> WP
      0 -> listOf(BR, BN, BB, BQ, BK, BB, BN, BR)[x]
      7 -> listOf(WR, WN, WB, WQ, WK, WB, WN, WR)[x]
      else -> null
    }
  }
}
