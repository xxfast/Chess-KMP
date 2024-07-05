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

enum class PieceColor {
  White, Black;
}

operator fun PieceColor.not(): PieceColor = if (this == White) Black else White

@Serializable
data class Piece(
  val type: PieceType,
  val color: PieceColor,
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
operator fun Board.get(at: Coordinate) = get(at.x, at.y)

enum class Cells() {
  a1, b1, c1, d1, e1, f1, g1, h1,
  a2, b2, c2, d2, e2, f2, g2, h2,
  a3, b3, c3, d3, e3, f3, g3, h3,
  a4, b4, c4, d4, e4, f4, g4, h4,
  a5, b5, c5, d5, e5, f5, g5, h5,
  a6, b6, c6, d6, e6, f6, g6, h6,
  a7, b7, c7, d7, e7, f7, g7, h7,
  a8, b8, c8, d8, e8, f8, g8, h8;

  val coordinate: Coordinate get() = name[0] - 'a' to name[1] - '1'
}

// Find the cells of the given type
operator fun Board.get(type: PieceType): List<Cell> =
  mapIndexedNotNull  { y, row ->
    row.mapIndexedNotNull { x, piece ->
      if (piece?.type == type) Cell(x to y, piece)
      else null
    }
  }
    .flatten()

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
  coordinate.x in 0..<maxWidth && coordinate.y in 0..<maxHeight

typealias Coordinate = Pair<Int, Int>

val Coordinate.x: Int get() = first
val Coordinate.y: Int get() = second

data class Cell(
  val coordinate: Coordinate,
  val piece: Piece,
)

@Serializable
data class Move(
  val piece: Piece,
  val from: Coordinate,
  val to: Coordinate,
) {
  constructor(piece: Piece, from: Cells, to: Cells) : this(piece, from.coordinate, to.coordinate)
}

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
data class Game(
  val board: Board = Standard,
  val turn: PieceColor = White,
  val moves: List<Move> = legalMoves(board, White),
  val history: List<String> = emptyList()
)


@Serializable
sealed class GameEvent {
  @Serializable
  data class MakeMove(val move: Move) : GameEvent()
}
