package io.github.xxfast.chess.screens.matchmake

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.chess.matchmaking.Invite
import io.github.xxfast.chess.matchmaking.InviteStatus.*
import io.github.xxfast.chess.matchmaking.Player
import io.github.xxfast.chess.resources.pieces.Pieces
import io.github.xxfast.chess.resources.pieces.pieces.Regular
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wn
import io.github.xxfast.decompose.router.rememberOnRoute
import kotlinx.coroutines.delay
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@Composable
fun ChessApplicationScope.MatchMakingScreen(
  onSettings: () -> Unit,
  onGame: () -> Unit,
) {
  val viewModel: MatchMakingViewModel =
    rememberOnRoute(MatchMakingViewModel::class) { MatchMakingViewModel(this) }

  val state: MatchMakingState by viewModel.state.collectAsState()

  MatchMakingView(
    state = state,
    onInvite = viewModel::onInvite,
    onAccept = viewModel::onAccept,
    onDecline = viewModel::onDecline,
    onWithdraw = viewModel::onWithdraw,
    onGame = onGame,
    onSettings = onSettings
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchMakingView(
  state: MatchMakingState,
  onInvite: (Player, Player) -> Unit,
  onAccept: (Invite) -> Unit,
  onDecline: (Invite) -> Unit,
  onWithdraw: (Invite) -> Unit,
  onGame: () -> Unit,
  onSettings: () -> Unit,
) {
  val scrollBehavior: TopAppBarScrollBehavior =
    TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

  val accepted: Invite? = state.invites?.find { it.status == ACCEPTED }
  var duration: Duration by remember(accepted) { mutableStateOf(REDIRECT_DURATION) }

  LaunchedEffect(accepted) {
    if (accepted == null) return@LaunchedEffect
    do  {
      delay(1.seconds)
      duration -= 1.seconds
    } while (duration > 0.seconds)
    onGame()
  }

  Scaffold(
    topBar = {
      LargeTopAppBar(
        title = {
          Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
              .fillMaxWidth()
              .padding(end = 16.dp)
          ) {
            Text("Chess-KMP")

            Spacer(modifier = Modifier.weight(1f))

            if (state.isOnline != Loading) Box(
              modifier = Modifier
                .size(8.dp)
                .background(
                  color = if (state.isOnline) MaterialTheme.colorScheme.primary
                  else MaterialTheme.colorScheme.error,
                  shape = CircleShape
                )
            )

            when {
              state.isOnline == Loading -> CircularProgressIndicator(modifier = Modifier.size(24.dp))
              state.isOnline -> Text(text = "Online", style = MaterialTheme.typography.bodyMedium)
              !state.isOnline -> Text(
                text = "Offline",
                style = MaterialTheme.typography.bodyMedium
              )
            }
          }
        },
        actions = {
          IconButton(onClick = onSettings) {
            Icon(Icons.Rounded.Settings, contentDescription = "Settings")
          }
        },
        scrollBehavior = scrollBehavior
      )
    },
  ) { scaffoldPadding ->
    LazyVerticalGrid(
      columns = GridCells.Adaptive(256.dp),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp),
      modifier = Modifier
        .padding(scaffoldPadding)
        .fillMaxSize()
        .nestedScroll(scrollBehavior.nestedScrollConnection)
        .imePadding()
    ) {
      if (state.invites?.isNotEmpty() == true) {
        item(span = { GridItemSpan(maxLineSpan) }) {
          Text(
            text = "Invites ${state.invites.size.let { "($it)" }}",
            style = MaterialTheme.typography.titleMedium
          )
        }

        if (state.invites == Loading) item(
          span = { GridItemSpan(maxLineSpan) }
        ) {
          Box(modifier = Modifier.fillMaxWidth()) {
            CircularProgressIndicator(
              modifier = Modifier
                .align(Alignment.Center)
            )
          }
        } else items(state.invites.toList()) { invite ->
          Card(
            colors = if (invite.from != state.player) CardDefaults.cardColors(
              containerColor = MaterialTheme.colorScheme.secondaryContainer,
              contentColor = MaterialTheme.colorScheme.onSecondaryContainer
            ) else CardDefaults.cardColors()
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(8.dp),
              modifier = Modifier
                .padding(16.dp)
            ) {
              if (invite.from == state.player) PlayerAvatar(invite.to)
              else PlayerAvatar(invite.from)

              Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                  text = if (invite.from == state.player) invite.to.name else invite.from.name,
                  style = MaterialTheme.typography.bodyLarge,
                  fontWeight = FontWeight.Bold.takeIf { invite.status != REJECTED },
                )

                Text(
                  text = when (invite.status) {
                    SENT -> if (invite.from == state.player) "Invite sent" else "Invite received"
                    REJECTED -> "Invite rejected"
                    ACCEPTED -> "Invite accepted, starting in $duration"
                  },
                  style = MaterialTheme.typography.bodySmall
                )
              }

              Spacer(modifier = Modifier.weight(1f))

              when {
                invite.status == SENT && invite.from != state.player -> {
                  IconButton(onClick = { onAccept(invite) }) {
                    Icon(Icons.Rounded.Check, null)
                  }

                  IconButton(onClick = { onDecline(invite) }) {
                    Icon(Icons.Rounded.Close, null)
                  }
                }

                invite.status == SENT || invite.status == REJECTED ->
                  IconButton(onClick = { onWithdraw(invite) }) {
                    Icon(Icons.Rounded.Delete, null)
                  }
              }
            }
          }
        }
      }

      item(span = { GridItemSpan(maxLineSpan) }) {
        Text(
          text = "Players online ${state.players?.size?.let { "($it)" }.orEmpty()}",
          style = MaterialTheme.typography.titleMedium
        )
      }

      if (state.players == Loading) item(
        span = { GridItemSpan(maxLineSpan) }
      ) {
        Box(modifier = Modifier.fillMaxWidth()) {
          CircularProgressIndicator(
            modifier = Modifier
              .align(Alignment.Center)
          )
        }
      } else items(state.players) { opponent ->
        val isEnabled =
          // Ignore self invites
          opponent != state.player &&
              // Ignore invites already sent
              state.invites?.none { it.to == opponent } == true

        Card(
          onClick = {
            if (state.player == null) return@Card
            onInvite(state.player, opponent)
          },
          enabled = isEnabled,
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
              .padding(16.dp)
          ) {
            PlayerAvatar(opponent)

            Text(
              text = opponent.name,
            )
          }
        }
      }
    }
  }
}

@Composable
private fun PlayerAvatar(
  player: Player,
  icon: @Composable () -> Unit = {
    Image(
      imageVector = Pieces.Regular.Wn,
      contentDescription = null,
      modifier = Modifier
        .size(48.dp)
    )
  },
) {
  Column(
    verticalArrangement = Arrangement.spacedBy(4.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    icon()

    Text(
      text = "${player.elo}",
      style = MaterialTheme.typography.bodyMedium,
      color = MaterialTheme.colorScheme.primary,
      fontWeight = FontWeight.ExtraBold
    )
  }
}
