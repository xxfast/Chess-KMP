package io.github.xxfast.chess.screens.game

fun Board.move(move: Move): Board = mapIndexed { y, row ->
  row.mapIndexed { x, cell ->
    when {
      // Move the piece
      x to y == move.to -> move.piece
      // Clear the cell
      x to y == move.from -> null
      // Or do nothing
      else -> cell
    }
  }
}

fun legalMoves(board: Board, turn: PieceColor): List<Move> = moves(board)
  // filter out the moves of pieces not of the current turn
  .filter { move -> move.piece.color == turn }
  // filter out moves that put the king in check
  .filter { move -> !move.inCheck(board, turn) }

private fun moves(board: Board): List<Move> = board
  .flatMapIndexed { y, row ->
    row.mapIndexedNotNull { x, piece ->
      when (piece?.type) {
        PieceType.Pawn -> pawnMoves(board, piece, x, y)
        PieceType.Bishop -> bishopMoves(board, piece, x, y)
        PieceType.Knight -> knightMoves(board, piece, x, y)
        PieceType.Rook -> rookMoves(board, piece, x, y)
        PieceType.Queen -> bishopMoves(board, piece, x, y) + rookMoves(board, piece, x, y)
        PieceType.King -> kingMoves(board, piece, x, y)
        null -> null
      }
    }
  }
  .flatten()

private fun Move.inCheck(board: Board, turn: PieceColor): Boolean {
  val moved: Board = board.move(this)
  val king: Cell = moved[PieceType.King, turn] ?: return false
  return moves(moved)
    .filter { it.piece.color != turn }
    .any { it.to == king.coordinate }
}

private fun pawnMoves(board: Board, piece: Piece, x: Int, y: Int): List<Move> {
  val forward: Int = if (piece.color == PieceColor.White) +1 else -1
  return listOfNotNull(
    // Move forward once
    Move(piece, x to y, x to y + forward)
      // if the cell in front is empty
      .takeIf { board[x, y + forward] == null }
      // if the cell is in bounds
      .takeIf { y + forward in 0 until board.maxHeight },

    // Or twice
    Move(piece, x to y, x to y + 2 * forward)
      // if it's their first move
      .takeIf { (piece.color == PieceColor.White && y == 1) || (piece.color == PieceColor.Black && y == board.lastY - 1) }
      // if the cells in front is empty
      .takeIf { board[x, y + forward] == null && board[x, y + 2 * forward] == null }
      // if the cells are in bounds
      .takeIf { y + 2 * forward in 0 until board.maxHeight },

    // Or capture diagonally
    Move(piece, x to y, x - 1 to y + forward)
      // if there's a piece of opposite color in the diagonal cell forward
      .takeIf { board[x - 1, y + forward] != null && board[x - 1, y + forward]?.color != piece.color },
    Move(piece, x to y, x + 1 to y + forward)
      // if there's a piece of opposite color in the diagonal cell forward
      .takeIf { board[x + 1, y + forward] != null && board[x + 1, y + forward]?.color != piece.color }

    // TODO: Google en passant
  )
}

private fun knightMoves(board: Board, piece: Piece, x: Int, y: Int): List<Move> {
  val directions: List<Pair<Int, Int>> = listOf(
    -2 to -1, -2 to 1, -1 to -2, -1 to 2,
    1 to -2, 1 to 2, 2 to -1, 2 to 1
  )
  return directions.mapNotNull { (dx, dy) ->
    val to = x + dx to y + dy
    val otherPiece = board[to.x, to.y]
    Move(piece, x to y, to).takeIf {
      to in board && (otherPiece == null || otherPiece.color != piece.color)
    }
  }
}

private fun bishopMoves(board: Board, piece: Piece, x: Int, y: Int): List<Move> = buildList {
  val directions: List<Pair<Int, Int>> = listOf(-1 to -1, -1 to 1, 1 to -1, 1 to 1)
  directions.forEach { (dx, dy) ->
    for (i in 1 until board.maxHeight) {
      val from: Coordinate = x to y
      val to: Coordinate = x + i * dx to y + i * dy
      val move = Move(piece, from, to)
      val otherPiece: Piece? = board[move.to.x, move.to.y]
      when {
        to !in board -> break
        otherPiece == null -> add(move)
        otherPiece.color != piece.color -> {
          add(move); break
        }

        else -> break
      }
    }
  }
}

private fun rookMoves(board: Board, piece: Piece, x: Int, y: Int): List<Move> = buildList {
  val directions: List<Pair<Int, Int>> = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
  directions.forEach { (dx, dy) ->
    for (i in 1 until board.maxHeight) {
      val from: Coordinate = x to y
      val to: Coordinate = x + i * dx to y + i * dy
      val move = Move(piece, from, to)
      val otherPiece: Piece? = board[move.to.x, move.to.y]
      when {
        to !in board -> break
        otherPiece == null -> add(move)
        otherPiece.color != piece.color -> {
          add(move); break
        }

        else -> break
      }
    }
  }
}

private fun kingMoves(board: Board, piece: Piece, x: Int, y: Int): List<Move> {
  val directions: List<Pair<Int, Int>> = listOf(
    -1 to -1, -1 to 0, -1 to 1,
    0 to -1, 0 to 1,
    1 to -1, 1 to 0, 1 to 1
  )

  // TODO: Implement castling
  return directions
    .mapNotNull { (dx, dy) ->
      val to = x + dx to y + dy
      val otherPiece = board[to.x, to.y]
      Move(piece, x to y, to)
        .takeIf { to in board && (otherPiece == null || otherPiece.color != piece.color) }
    }
}
