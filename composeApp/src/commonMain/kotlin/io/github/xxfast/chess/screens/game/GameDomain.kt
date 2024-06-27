package io.github.xxfast.chess.screens.game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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