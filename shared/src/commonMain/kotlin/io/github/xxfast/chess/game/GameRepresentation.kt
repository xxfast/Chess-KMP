package io.github.xxfast.chess.game

import io.github.xxfast.chess.game.PieceColor.*
import io.github.xxfast.chess.game.PieceType.*

// Represents a piece in algebraic notation
val PieceType.text: String get() = when (this) {
  Pawn -> ""
  Knight -> "N"
  Bishop -> "B"
  Rook -> "R"
  Queen -> "Q"
  King -> "K"
}

// Represents a piece in algebraic notation
val Piece.text: String get() = type.text

// Represents a coordinate in algebraic notation
val Coordinate.text: String get() = "${'a' + x}${y + 1}"

// Represents a move in algebraic notation for a given board
fun Move.text(board: Board): String = buildString {
  val piece: Piece = requireNotNull(board[from]) { "Piece not found at ${from.text}" }

  // If the move is a pawn move, the piece type is omitted.
  if (piece.type != Pawn) {
    append(piece.text)
  }

  // When a pawn makes a capture, the file from which the pawn departed is used to identify the pawn
  if (piece.type == Pawn && board[to] != null) {
    append('a' + from.x)
  }

  // If the move is a capture, an "x" is inserted immediately before the destination square.
  if (board[to] != null) {
    append('x')
  }

  append(to.text)

  // If the move gives checkmate, "#" is added to the end of the move.
  val moved: Board = board.move(this@text)
  val opponentMoves = legalMoves(moved, !this@text.piece.color)
  val isCheckMate = opponentMoves.all { it.inCheck(moved) }

  if (isCheckMate) {
    append('#')
    return@buildString
  }

  // If the move gives check, a "+" is added to the end of the move.
  val king = moved[King, !piece.color]!!
  val inCheck = legalMoves(moved, piece.color)
    .filter { move -> move.piece.color == piece.color }
    .any { move  -> king.coordinate == move.to }
  if (inCheck) append('+')
}

// Represent a board graphically on the console
fun Board.print() {
  for (y in maxHeight-1 downTo 0) {
    for (x in 0 until maxWidth) {
      val piece: Piece? = this[x, y]
      val symbol = when(piece?.color){
        null -> '.'
        White -> when(piece.type) {
          Pawn -> '♙'
          Knight -> '♘'
          Bishop -> '♗'
          Rook -> '♖'
          Queen -> '♕'
          King -> '♔'
        }
        Black -> when(piece.type) {
          Pawn -> '♟'
          Knight -> '♞'
          Bishop -> '♝'
          Rook -> '♜'
          Queen -> '♛'
          King -> '♚'
        }
      }
      print(symbol)
    }
    println()
  }
}

// Represents a board in fen notation
val Board.fen: String get() = buildString {
  var empty = 0
  for (y in 0 until maxHeight) {
    for (x in 0 until maxWidth) {
      val piece: Piece? = this@fen[x, y]
      if (piece == null) {
        empty++
      } else {
        if (empty > 0) {
          append(empty)
          empty = 0
        }
        append(piece.text)
      }
    }
    if (empty > 0) {
      append(empty)
      empty = 0
    }
    if (y < lastY) {
      append('/')
    }
  }
}
