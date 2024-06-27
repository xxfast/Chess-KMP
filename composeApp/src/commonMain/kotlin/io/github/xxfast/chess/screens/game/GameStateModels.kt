package io.github.xxfast.chess.screens.game

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.xxfast.chess.game.Piece
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
import io.github.xxfast.chess.game.PieceColor.Black
import io.github.xxfast.chess.game.PieceColor.White
import io.github.xxfast.chess.game.PieceType.Bishop
import io.github.xxfast.chess.game.PieceType.King
import io.github.xxfast.chess.game.PieceType.Knight
import io.github.xxfast.chess.game.PieceType.Pawn
import io.github.xxfast.chess.game.PieceType.Queen
import io.github.xxfast.chess.game.PieceType.Rook

// TODO: Swapping the assets for dark theme for better consistancy
val Piece.icon: ImageVector
  @Composable get() =
    if (isSystemInDarkTheme()) when {
      this.type == Pawn && this.color == White -> Pieces.Regular.Bp
      this.type == Knight && this.color == White -> Pieces.Regular.Bn
      this.type == Bishop && this.color == White -> Pieces.Regular.Bb
      this.type == Rook && this.color == White -> Pieces.Regular.Br
      this.type == Queen && this.color == White -> Pieces.Regular.Bq
      this.type == King && this.color == White -> Pieces.Regular.Bk
      this.type == Pawn && this.color == Black -> Pieces.Regular.Wp
      this.type == Knight && this.color == Black -> Pieces.Regular.Wn
      this.type == Bishop && this.color == Black -> Pieces.Regular.Wb
      this.type == Rook && this.color == Black -> Pieces.Regular.Wr
      this.type == Queen && this.color == Black -> Pieces.Regular.Wq
      this.type == King && this.color == Black -> Pieces.Regular.Wk
      else -> error("Invalid piece $this")
    } else when {
      this.type == Pawn && this.color == White  -> Pieces.Regular.Wp
      this.type == Knight && this.color == White  -> Pieces.Regular.Wn
      this.type == Bishop && this.color == White  -> Pieces.Regular.Wb
      this.type == Rook && this.color == White  -> Pieces.Regular.Wr
      this.type == Queen && this.color == White  -> Pieces.Regular.Wq
      this.type == King && this.color == White  -> Pieces.Regular.Wk
      this.type == Pawn && this.color == Black  -> Pieces.Regular.Bp
      this.type == Knight && this.color == Black  -> Pieces.Regular.Bn
      this.type == Bishop && this.color == Black  -> Pieces.Regular.Bb
      this.type == Rook && this.color == Black  -> Pieces.Regular.Br
      this.type == Queen && this.color == Black  -> Pieces.Regular.Bq
      this.type == King && this.color == Black  -> Pieces.Regular.Bk
      else -> error("Invalid piece $this")
    }
