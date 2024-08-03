package io.github.xxfast.chess.game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import io.github.xxfast.chess.discovery.Match
import io.github.xxfast.chess.discovery.MatchId
import io.github.xxfast.chess.discovery.Player
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

val globalMatches: MutableStateFlow<List<Match>> = MutableStateFlow(emptyList())

@Composable
fun GameDomain(id: MatchId, player: Player, events: SharedFlow<GameEvent>): Match {
  val match: Match by globalMatches
    .map { matches -> matches.first { match -> match.id == id } }
    .collectAsState(Match(game = Game(), scores = emptyList(), id = id))

  // Calculate time taken for each turn
  var turnTime: Duration by remember(match.game.turn) { mutableStateOf(0.seconds) }

  LaunchedEffect(match.game.turn) {
    while (true) {
      turnTime += 1.seconds
      delay(1.seconds)
    }
  }

  LaunchedEffect(Unit) {
    events.collect { event ->
      when (event) {
        is GameEvent.MakeMove -> {
          val board: Board = match.game.board.move(event.move)
          val nextTurn: PieceColor = !match.game.turn
          val moves: List<Move> = legalMoves(board, nextTurn)

          // Update history
          val move = event.move.text(match.game.board)
          val history: List<String> = match.game.history + "$move ($turnTime)"

          // Update game
          val game: Game = match.game.copy(
            board = board,
            turn = nextTurn,
            moves = moves,
            history = history
          )

          println()
          println("Previous times: ${match.scores.map { it.time }}")

          // Update scores
          val players = match.scores
            .map { score ->
              if (score.color != match.game.turn) score
              else score.copy(time = score.time - turnTime)
            }

          println("Event time for ${player.name}: $turnTime")
          println("Updated times: ${players.map { it.time }}")

          println()

          globalMatches.update { matches: List<Match> ->
            matches.map {
              if (it.id != match.id) it
              else it.copy(game = game, scores = players)
            }
          }
        }
      }
    }
  }

  return match
}