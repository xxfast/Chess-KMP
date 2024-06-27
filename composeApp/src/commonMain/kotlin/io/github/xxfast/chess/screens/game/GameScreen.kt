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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import io.github.xxfast.chess.game.GameState
import io.github.xxfast.chess.game.Move
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
fun GameScreen(
  onClose: () -> Unit,
) {
  val viewModel: GameViewModel = rememberOnRoute(GameViewModel::class) { context ->
    GameViewModel(context)
  }

  val state: GameState by viewModel.state.collectAsState()

  GameView(
    state = state,
    onMove = viewModel::onMove,
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
