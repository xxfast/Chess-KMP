package io.github.xxfast.chess.screens.game

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun GameScreen(
  onClose: () -> Unit,
) {
  var state: GameState by remember { mutableStateOf(GameState()) }

  GameView(
    state = state,
    onMove = { move ->
      val turn: PieceColor = !state.turn
      val board: Board = state.board.move(move)
      val moves: List<Move> = legalMoves(board, turn)
      state = state.copy(board = board, turn = turn, moves = moves)
    },
    onClose = onClose,
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameView(
  state: GameState,
  onMove: (move: Move) -> Unit,
  onClose: () -> Unit,
) {
  Scaffold(
    topBar = {
      LargeTopAppBar(
        title = { Text("Game") },
        navigationIcon = {
          IconButton(onClick = onClose) {
            Icon(Icons.Rounded.Close, null)
          }
        }
      )
    },
  ) { scaffoldPadding ->
    GameBoard(
      state = state,
      onMove = onMove,
      modifier = Modifier
        .padding(scaffoldPadding)
        .fillMaxSize()
    )
  }
}
