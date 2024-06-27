package io.github.xxfast.chess.game

import io.github.xxfast.chess.game.Piece.Companion.BlackBishop
import io.github.xxfast.chess.game.Piece.Companion.BlackKing
import io.github.xxfast.chess.game.Piece.Companion.BlackKnight
import io.github.xxfast.chess.game.Piece.Companion.BlackPawn
import io.github.xxfast.chess.game.Piece.Companion.BlackQueen
import io.github.xxfast.chess.game.Piece.Companion.BlackRook
import io.github.xxfast.chess.game.Piece.Companion.WhiteBishop
import io.github.xxfast.chess.game.Piece.Companion.WhiteKing
import io.github.xxfast.chess.game.Piece.Companion.WhiteKnight
import io.github.xxfast.chess.game.Piece.Companion.WhitePawn
import io.github.xxfast.chess.game.Piece.Companion.WhiteQueen
import io.github.xxfast.chess.game.Piece.Companion.WhiteRook
import io.github.xxfast.chess.game.PieceColor.Black
import io.github.xxfast.chess.game.PieceColor.White
import kotlinx.serialization.Serializable

enum class PieceType { Pawn, Knight, Bishop, Rook, Queen, King }

enum class PieceColor { White, Black ; }
operator fun PieceColor.not(): PieceColor = if (this == White) Black else White

@Serializable
data class Piece(
  val type: PieceType,
  val color: PieceColor
) {
  companion object {
    val WhitePawn = Piece(PieceType.Pawn, White)
    val WhiteKnight = Piece(PieceType.Knight, White)
    val WhiteBishop = Piece(PieceType.Bishop, White)
    val WhiteRook = Piece(PieceType.Rook, White)
    val WhiteQueen = Piece(PieceType.Queen, White)
    val WhiteKing = Piece(PieceType.King, White)
    val BlackPawn = Piece(PieceType.Pawn, Black)
    val BlackKnight = Piece(PieceType.Knight, Black)
    val BlackBishop = Piece(PieceType.Bishop, Black)
    val BlackRook = Piece(PieceType.Rook, Black)
    val BlackQueen = Piece(PieceType.Queen, Black)
    val BlackKing = Piece(PieceType.King, Black)
  }
}

typealias Board = List<List<Piece?>>
val Board.maxWidth: Int get() = maxOf { it.size }
val Board.maxHeight: Int get() = size
val Board.lastY: Int get() = size - 1
operator fun Board.get(x: Int, y: Int): Piece? = getOrNull(y)?.getOrNull(x)

// Find the cell of the given type and color
operator fun Board.get(type: PieceType, color: PieceColor): Cell? {
  forEachIndexed { y, row ->
    row.forEachIndexed { x, piece ->
      if (piece?.type == type && piece.color == color) {
        return Cell(x to y, piece)
      }
    }
  }
  return null
}

operator fun Board.contains(coordinate: Coordinate): Boolean =
  coordinate.x in 0.. maxWidth && coordinate.y in 0 ..  maxHeight

typealias Coordinate = Pair<Int, Int>
val Coordinate.x: Int get() = first
val Coordinate.y: Int get() = second
val Coordinate.text: String get() {
  val coordinateX = "abcdefgh"[x]
  val coordinateY = y + 1
  return "$coordinateX$coordinateY"
}

data class Cell(
  val coordinate: Coordinate,
  val piece: Piece
)

@Serializable
data class Move(
  val piece: Piece,
  val from: Coordinate,
  val to: Coordinate
)

val Standard: Board = List(8) { y ->
  List(8) { x ->
    when (y) {
      0 -> listOf(WhiteRook, WhiteKnight, WhiteBishop, WhiteQueen, WhiteKing, WhiteBishop, WhiteKnight, WhiteRook)[x]
      1 -> WhitePawn
      6 -> BlackPawn
      7 -> listOf(BlackRook, BlackKnight, BlackBishop, BlackQueen, BlackKing, BlackBishop, BlackKnight, BlackRook)[x]
      else -> null
    }
  }
}

@Serializable
data class GameState(
  val board: Board = Standard,
  val turn: PieceColor = White,
  val moves: List<Move> = emptyList()
)

@Serializable
sealed class GameEvent {
  @Serializable data class MakeMove(val move: Move) : GameEvent()
}
