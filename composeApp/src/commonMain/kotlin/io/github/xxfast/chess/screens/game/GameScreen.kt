package io.github.xxfast.chess.screens.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.mohamedrejeb.compose.dnd.DragAndDropContainer
import com.mohamedrejeb.compose.dnd.DragAndDropState
import com.mohamedrejeb.compose.dnd.drag.DraggableItem
import com.mohamedrejeb.compose.dnd.drop.dropTarget
import com.mohamedrejeb.compose.dnd.rememberDragAndDropState

const val DEBUG = true

@Composable
fun GameScreen() {
  var state: GameState by remember { mutableStateOf(GameState()) }

  GameView(
    state = state,
    onMove = { piece, from, to ->
      state = state.copy(
        board = state.board.mapIndexed { y, row ->
          row.mapIndexed { x, cell ->
            when {
              // Move the piece
              x to y == to -> piece

              // Clear the cell
              x to y == from -> null

              // Or do nothing
              else -> cell
            }
          }
        }
      )
    }
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameView(
  state: GameState,
  onMove: (Piece, from: Coordinate, to: Coordinate) -> Unit,
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
      onMove = onMove,
      modifier = Modifier
        .padding(scaffoldPadding)
        .fillMaxSize()
    )
  }
}

@Composable
fun GameBoard(
  state: GameState,
  onMove: (Piece, from: Coordinate, to: Coordinate) -> Unit,
  modifier: Modifier = Modifier,
) {
  val dragAndDropState: DragAndDropState<Cell> = rememberDragAndDropState()

  DragAndDropContainer(state = dragAndDropState) {
    BoxWithConstraints(modifier) {
      val maxSize: Int = maxOf(state.board.maxWidth, state.board.maxHeight)
      val cellSize: Dp = min(this.maxWidth, this.maxHeight) / maxSize

      Column {
        // TODO: Flip the board so that the player's perspective is always from the bottom
        state.board.reversed().forEachIndexed { fy, row ->
          Row {
            row.forEachIndexed { x, piece ->
              val y = state.board.maxHeight - 1 - fy
              val isEvenRow = y % 2 == 0
              val isEvenColumn = x % 2 == 0
              val coordinate: Coordinate = x to y

              Surface(
                color =
                if (isEvenRow xor isEvenColumn) MaterialTheme.colorScheme.primaryContainer
                else MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                  .size(cellSize)
                  .dropTarget(
                    state = dragAndDropState,
                    key = coordinate,
                    onDrop = { state ->
                      onMove(state.data.piece, state.data.coordinate, coordinate)
                    }
                  )
              ) {
                if (piece != null) {
                  val cell = Cell(coordinate, piece)

                  DraggableItem(
                    state = dragAndDropState,
                    key = cell,
                    data = cell,
                  ) {
                    if (!isDragging) Image(
                      imageVector = piece.icon,
                      contentDescription = null,
                      modifier = Modifier
                        .padding(4.dp),
                    )
                  }
                }

                if (DEBUG) {
                  Text(
                    text = coordinate.text,
                    modifier = Modifier.padding(2.dp),
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.bodySmall,
                  )
                }
              }
            }

          }
        }
      }
    }
  }
}


