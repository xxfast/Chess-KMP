package io.github.xxfast.chess.game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.github.xxfast.chess.discovery.Match
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow

val globalMatches: MutableStateFlow<List<Match>> = MutableStateFlow(emptyList())

@Composable
fun GameDomain(id: String, events: SharedFlow<GameEvent>): Match {
  val matches: List<Match> by globalMatches.collectAsState()

  val match: Match = matches.find { match -> match.id == id }
    ?: throw IllegalStateException("Game not found")

  LaunchedEffect(Unit) {
    events.collect { event ->
      when (event) {
        is GameEvent.MakeMove -> {
          val board: Board = match.game.board.move(event.move)
          val turn: PieceColor = !match.game.turn
          val moves: List<Move> = legalMoves(board, turn)
          val game: Game = match.game.copy(board = board, turn = turn, moves = moves)
          globalMatches.value = matches.map { if (it == match) match.copy(game = game) else it }
        }
      }
    }
  }

  return match
}