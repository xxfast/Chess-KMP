package io.github.xxfast.chess.game

import io.github.xxfast.chess.game.Cells.*
import io.github.xxfast.chess.game.Piece.Companion.BlackBishop
import io.github.xxfast.chess.game.Piece.Companion.BlackKnight
import io.github.xxfast.chess.game.Piece.Companion.BlackPawn
import io.github.xxfast.chess.game.Piece.Companion.BlackQueen
import io.github.xxfast.chess.game.Piece.Companion.WhiteBishop
import io.github.xxfast.chess.game.Piece.Companion.WhiteKnight
import io.github.xxfast.chess.game.Piece.Companion.WhitePawn
import io.github.xxfast.chess.game.Piece.Companion.WhiteQueen
import kotlin.test.Test
import kotlin.test.assertEquals

class TestGameRepresentation {


  @Test
  fun testMoveRepresentation() {
    var board = Standard

    val moves = mapOf(
      "e4" to  Move(WhitePawn, e2, e4),
      "e5" to Move(BlackPawn, e7, e5),
      "Nf3" to Move(WhiteKnight, g1, f3),
      "Nf6" to Move(BlackKnight, g8, f6),
      "Nxe5" to Move(WhiteKnight, f3, e5),
      "Nxe4" to Move(BlackKnight, f6, e4),
      "Qe2" to Move(WhiteQueen, d1, e2),
      "Nd6" to Move(BlackKnight, e4, d6),
      "Nc6+" to Move(WhiteKnight, e5, c6),
      "Qe7" to Move(BlackQueen, d8, e7),
      "Nxe7" to Move(WhiteKnight, c6, e7),
      "Bxe7" to Move(BlackBishop, f8, e7),
      "d4" to Move(WhitePawn, d2, d4),
      "c5" to Move(BlackPawn, c7, c5),
      "Bg5" to Move(WhiteBishop, c1, g5),
      "cxd4" to Move(BlackPawn, c5, d4),
      "Qxe7#" to Move(WhiteQueen, e2, e7),
    )

    moves.forEach { (expect, move) ->
      println()
      println(expect)
      board.move(move).print()
      assertEquals(expect, move.text(board))
      board = board.move(move)
    }
  }
}