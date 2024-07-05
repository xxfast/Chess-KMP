package io.github.xxfast.chess.game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.github.xxfast.chess.discovery.Match
import io.github.xxfast.chess.discovery.MatchId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

val globalMatches: MutableStateFlow<List<Match>> = MutableStateFlow(emptyList())

@Composable
fun GameDomain(id: MatchId, events: SharedFlow<GameEvent>): Match {
  val match: Match by globalMatches
    .map { matches -> matches.first { match -> match.id == id } }
    .collectAsState(Match(game = Game(), players = emptyMap(), id = id))

  LaunchedEffect(Unit) {
    events.collect { event ->
      when (event) {
        is GameEvent.MakeMove -> {
          val board: Board = match.game.board.move(event.move)
          val turn: PieceColor = !match.game.turn
          val moves: List<Move> = legalMoves(board, turn)
          val history: List<String> = match.game.history + event.move.text(match.game.board)
          val game: Game = match.game.copy(board = board, turn = turn, moves = moves, history = history)
          globalMatches.update { matches: List<Match> ->
            matches.map { if (it.id == match.id) it.copy(game = game) else it }
          }
        }
      }
    }
  }

  return match
}