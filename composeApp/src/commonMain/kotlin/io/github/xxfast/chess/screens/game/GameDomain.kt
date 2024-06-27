package io.github.xxfast.chess.screens.game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import io.github.xxfast.chess.game.Board
import io.github.xxfast.chess.game.GameEvent
import io.github.xxfast.chess.game.GameState
import io.github.xxfast.chess.game.PieceColor
import io.github.xxfast.chess.game.Standard
import io.github.xxfast.chess.game.legalMoves
import io.github.xxfast.chess.game.move
import io.github.xxfast.chess.game.not
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun GameDomain(events: SharedFlow<GameEvent>): GameState {
  var board: Board by remember { mutableStateOf(Standard) }
  var turn: PieceColor by remember { mutableStateOf(PieceColor.White) }

  LaunchedEffect(Unit){
    events.collect {event ->
      when(event){
        is GameEvent.MakeMove -> {
          turn = !turn
          board = board.move(event.move)
        }
      }
    }
  }

  return GameState(
    board = board,
    turn = turn,
    moves = legalMoves(board, turn)
  )
}