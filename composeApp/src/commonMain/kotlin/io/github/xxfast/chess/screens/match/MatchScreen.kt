package io.github.xxfast.chess.screens.match

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.chess.components.GameBoard
import io.github.xxfast.chess.discovery.MatchId
import io.github.xxfast.chess.game.Move
import io.github.xxfast.chess.game.PieceColor
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
fun ChessApplicationScope.MatchScreen(
  id: MatchId,
  onClose: () -> Unit,
) {
  val viewModel: MatchViewModel =
    rememberOnRoute(MatchViewModel::class) { context -> MatchViewModel(context, this, id) }

  val state: MatchState by viewModel.state.collectAsState()

  MatchView(
    state = state,
    onMove = viewModel::onMove,
    onClose = onClose,
  )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MatchView(
  state: MatchState,
  onMove: (move: Move) -> Unit,
  onClose: () -> Unit,
) {
  val scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

  // Flip if the user is white
  val flip: Boolean = state.user == state.match?.players?.get(PieceColor.White)

  Scaffold(
    topBar = {
      LargeTopAppBar(
        title = { Text("Game") },
        navigationIcon = {
          IconButton(onClick = onClose) {
            Icon(Icons.Rounded.Close, null)
          }
        },
        scrollBehavior = scrollBehavior
      )
    },
  ) { scaffoldPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(scaffoldPadding)
        .scrollable(orientation = Orientation.Vertical, state = rememberScrollState())
        .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        if (state.match?.game == Loading) CircularProgressIndicator()
        else GameBoard(
          game = state.match.game,
          flip = flip,
          onMove = onMove,
        )

        Text(
          text = "Moves",
          style = MaterialTheme.typography.titleMedium,
          modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        )

        FlowRow (
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          modifier = Modifier.padding(horizontal = 16.dp)
        ) {
          state.match?.game?.history?.forEach { move ->
            FilterChip(
              selected = false,
              label = { Text(move) },
              onClick = { }
            )
          }
        }
    }
  }
}
