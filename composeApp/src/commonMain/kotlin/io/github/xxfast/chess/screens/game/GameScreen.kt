package io.github.xxfast.chess.screens.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun GameView(
  state: GameState = GameState(),
) {
  Scaffold(
    topBar = {
      LargeTopAppBar(
        title = { Text("Game") },
        navigationIcon = {
          IconButton(onClick = {}) {
            Icon(Icons.Rounded.Close, null)
          }
        }
      )
    },
  ) { scaffoldPadding ->
    GameBoard(
      state = state,
      modifier = Modifier
        .padding(scaffoldPadding)
        .fillMaxSize()
    )
  }
}

@Composable
fun GameBoard(
  state: GameState,
  modifier: Modifier = Modifier,
) {
  BoxWithConstraints(modifier) {
    val maxWidth = state.board.maxOf { it.size }
    val maxHeight = state.board.size
    val maxSize: Int = maxOf(maxWidth, maxHeight)
    val cellSize: Dp = min(this.maxWidth, this.maxHeight) / maxSize

    Column {
      state.board.forEachIndexed { y, row ->
        Row {
          row.forEachIndexed { x, piece ->
            val isEvenRow = y % 2 == 0
            val isEvenColumn = x % 2 == 0
            Surface(
              color =
              if (isEvenRow xor isEvenColumn) MaterialTheme.colorScheme.primaryContainer
              else MaterialTheme.colorScheme.surface,
              shape = MaterialTheme.shapes.small,
              modifier = Modifier
                .size(cellSize)
            ) {
              if (piece != null) Image(
                imageVector = piece.icon,
                contentDescription = null,
                modifier = Modifier
                  .padding(4.dp),
              )
            }
          }

        }
      }
    }
  }
}


