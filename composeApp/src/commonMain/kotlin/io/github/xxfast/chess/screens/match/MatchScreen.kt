package io.github.xxfast.chess.screens.match

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Flag
import androidx.compose.material.icons.outlined.Handshake
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.chess.components.GameBoard
import io.github.xxfast.chess.components.PlayerAvatar
import io.github.xxfast.chess.components.PlayerTitle
import io.github.xxfast.chess.discovery.MatchId
import io.github.xxfast.chess.discovery.PlayerScore
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
  val flip: Boolean = state.userScore?.color == PieceColor.White

  Scaffold(
    topBar = {
      LargeTopAppBar(
        title = {
          Row(modifier = Modifier.padding(end = 8.dp)) {
            if (state.opponentScore == Loading) CircularProgressIndicator()
            else PlayerScoreBoard(state.opponentScore, state.game?.turn)
          }
        },
        navigationIcon = {
          IconButton(onClick = onClose) {
            Icon(Icons.Rounded.Close, null)
          }
        },
        actions = {
          IconButton(onClick = {}) {
            Icon(Icons.Outlined.Flag, null)
          }

          IconButton(onClick = {}) {
            Icon(Icons.Outlined.Handshake, null)
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
      if (state.game == Loading) CircularProgressIndicator()
      else GameBoard(
        game = state.game,
        flip = flip,
        onMove = onMove,
      )

      Row(modifier = Modifier.padding(8.dp)) {
        if (state.userScore == Loading) CircularProgressIndicator()
        else PlayerScoreBoard(state.userScore, state.game?.turn)
      }


      Text(
        text = "Moves",
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
      )

      FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 16.dp)
      ) {
        state.game?.history?.forEach { move ->
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

@Composable
fun PlayerScoreBoard(
  score: PlayerScore,
  turn: PieceColor?,
) {
  Row(
    horizontalArrangement = Arrangement.spacedBy(2.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.fillMaxWidth()
        .weight(1f)
    ) {
      PlayerAvatar(score.player)
      PlayerTitle(score.player)
    }

    Card(
      colors = CardDefaults.cardColors(
        contentColor =
        if(turn == score.color) MaterialTheme.colorScheme.inverseOnSurface
        else CardDefaults.cardColors().disabledContentColor,
        containerColor =
         if(turn == score.color) MaterialTheme.colorScheme.inverseSurface
        else CardDefaults.cardColors().disabledContainerColor,
      ),
      shape = MaterialTheme.shapes.small,
      modifier = Modifier,
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterHorizontally),
        modifier = Modifier
          .padding(4.dp)
      ) {
        Icon(Icons.Outlined.Timer, null)

        val minutes: String = score.time.inWholeMinutes.toString().padStart(2, '0')
        val seconds: String = (score.time.inWholeSeconds % 60).toString().padStart(2, '0')

        Text(
          text = "$minutes:$seconds",
          style = MaterialTheme.typography.titleMedium,
          modifier = Modifier.padding(8.dp)
        )
      }
    }
  }
}
