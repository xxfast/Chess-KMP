package io.github.xxfast.chess.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.mohamedrejeb.compose.dnd.DragAndDropContainer
import com.mohamedrejeb.compose.dnd.DragAndDropState
import com.mohamedrejeb.compose.dnd.drag.DraggableItem
import com.mohamedrejeb.compose.dnd.drop.dropTarget
import com.mohamedrejeb.compose.dnd.rememberDragAndDropState
import io.github.xxfast.chess.game.Board
import io.github.xxfast.chess.game.Cell
import io.github.xxfast.chess.game.Coordinate
import io.github.xxfast.chess.game.Game
import io.github.xxfast.chess.game.Move
import io.github.xxfast.chess.game.Piece
import io.github.xxfast.chess.game.get
import io.github.xxfast.chess.game.maxHeight
import io.github.xxfast.chess.game.maxWidth
import io.github.xxfast.chess.game.text
import io.github.xxfast.chess.resources.ChessTheme
import io.github.xxfast.chess.screens.match.icon
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

@Composable
fun GameBoard(
  game: Game,
  flip: Boolean = false,
  isCompact: Boolean = false,
  showCoordinates: Boolean = false,
  onMove: ((move: Move) -> Unit)? = null,
  modifier: Modifier = Modifier,
) {
  val dragAndDropState: DragAndDropState<Cell> = rememberDragAndDropState()
  var selected: Cell? by remember { mutableStateOf(null) }
  val dragged: Cell? by remember { derivedStateOf { dragAndDropState.draggedItem?.data } }

  LaunchedEffect(dragged) { selected = dragged }

  DragAndDropContainer(state = dragAndDropState) {
    BoxWithConstraints(modifier) {
      val maxSize: Int = maxOf(game.board.maxWidth, game.board.maxHeight)
      val cellSize: Dp = min(this.maxWidth, this.maxHeight) / maxSize

      val board: Board = if (flip) game.board.reversed() else game.board
      Column {
        // TODO: Flip the board so that the player's perspective is always from the bottom
        board.forEachIndexed { dy, row ->
          val y = if (flip) game.board.maxHeight - 1 - dy else dy
          Row {
            row.forEachIndexed { x, piece ->
              val isEvenRow = dy % 2 == 0
              val isEvenColumn = x % 2 == 0
              val coordinate: Coordinate = x to y

              val allowedMove: Boolean = game.moves.any { move ->
                val fromPiece: Piece = game.board[move.from] ?: return@any false
                fromPiece == selected?.piece &&
                    move.from == selected?.coordinate &&
                    move.to == coordinate
              }

              val isEnabled: Boolean = piece?.color == game.turn || allowedMove
              val selection: Cell? = selected

              Surface(
                onClick = {
                  // if there is a selection and this cell is allowed
                  if (onMove != null && selection != null && allowedMove) {
                    // make the move
                    onMove(Move(selection.piece, selection.coordinate, coordinate))
                    // clear the selection
                    selected = null

                    // If not
                  } else {
                    selected =
                        // if there is a piece in this cell
                      if (selection?.coordinate != coordinate && piece != null)
                      // set the selection
                        Cell(coordinate, piece)
                      // else clear the selection
                      else null
                  }
                },
                enabled = onMove != null && isEnabled,
                color =
                when {
                  selected?.coordinate == coordinate -> MaterialTheme.colorScheme.inversePrimary
                  isEvenRow xor isEvenColumn -> MaterialTheme.colorScheme.primaryContainer
                  else -> MaterialTheme.colorScheme.surface
                },
                shape =  MaterialTheme.shapes.small,
                modifier = Modifier
                  .size(cellSize)
                  .then(
                    if (allowedMove) Modifier.dropTarget(
                      state = dragAndDropState,
                      key = coordinate,
                      onDrop = { state ->
                        onMove?.invoke(Move(state.data.piece, state.data.coordinate, coordinate))
                      }
                    ) else Modifier
                  )
              ) {

                val distanceToPiece = selected?.coordinate
                  ?.let { (sx, sy) ->
                    sqrt(
                      (x - sx).toDouble().pow(2) + (y - sy).toDouble().pow(2)
                    )
                  }
                  ?.roundToInt()
                  ?: 0

                // Show move or capture indicator
                AnimatedVisibility(
                  visible = allowedMove,
                  enter = fadeIn(tween(AnimationConstants.DefaultDurationMillis * distanceToPiece))
                ) {
                  Box(modifier = Modifier.fillMaxSize()) {
                    val color: Color =
                      if (dragAndDropState.hoveredDropTargetKey == coordinate)
                        MaterialTheme.colorScheme.primary
                      else MaterialTheme.colorScheme.inversePrimary

                    if (piece == null) Box(
                      modifier = Modifier
                        .background(color, CircleShape)
                        .size(16.dp)
                        .align(Alignment.Center)
                    ) else Box(
                      modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .border(6.dp, color, CircleShape)
                    )
                  }
                }

                if (piece != null) {
                  val cell = Cell(coordinate, piece)
                  DraggableItem(
                    state = dragAndDropState,
                    key = cell,
                    data = cell,
                    enabled = onMove != null,
                  ) {
                    if (!isDragging) Image(
                      imageVector = piece.icon,
                      contentDescription = null,
                      modifier = Modifier
                        .then(
                          if (!isCompact) Modifier.padding(4.dp)
                          else Modifier.padding(1.dp)
                        ),
                    )
                  }
                }

                if (showCoordinates) Text(
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


@Preview
@Composable
fun GameBoardCommonPreview() {
  ChessTheme {
    Surface {
      GameBoard(
        game = Game(),
        onMove = { _ -> }
      )
    }
  }
}