package io.github.xxfast.chess.screens.matchmake

import KottieAnimation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.chess.components.MatchView
import io.github.xxfast.chess.components.PlayerAvatar
import io.github.xxfast.chess.discovery.Invite
import io.github.xxfast.chess.discovery.InviteStatus.ACCEPTED
import io.github.xxfast.chess.discovery.InviteStatus.REJECTED
import io.github.xxfast.chess.discovery.InviteStatus.SENT
import io.github.xxfast.chess.discovery.Match
import io.github.xxfast.chess.discovery.Player
import io.github.xxfast.chess.game.Game
import io.github.xxfast.chess.resources.Animations
import io.github.xxfast.decompose.router.rememberOnRoute
import kottieAnimationState.KottieAnimationState
import kottieComposition.KottieCompositionSpec
import kottieComposition.animateKottieCompositionAsState
import kottieComposition.rememberKottieComposition
import utils.KottieConstants

@Composable
fun ChessApplicationScope.MatchMakingScreen(
  onSettings: () -> Unit,
  onGame: (Match) -> Unit,
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
  onGame: (Match) -> Unit,
  onSettings: () -> Unit,
) {
  val scrollBehavior: TopAppBarScrollBehavior =
    TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

  Scaffold(
    topBar = { TopAppBar(state.isOnline, onSettings, scrollBehavior) },
  ) { scaffoldPadding ->
    if (state.isOnline != true) LoadingView(
      modifier = Modifier.padding(scaffoldPadding)
    ) else LazyVerticalGrid(
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
      GamesView(state.matches, onGame)
      InvitesView(state.player, state.invites, onAccept, onDecline, onWithdraw)
      PlayersView(state.player, state.players, state.invites, onInvite)
    }
  }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopAppBar(
  isOnline: Boolean?,
  onSettings: () -> Unit,
  scrollBehavior: TopAppBarScrollBehavior,
) {
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

        if (isOnline != Loading) Box(
          modifier = Modifier
            .size(8.dp)
            .background(
              color = if (isOnline) MaterialTheme.colorScheme.primary
              else MaterialTheme.colorScheme.error,
              shape = CircleShape
            )
        )

        when {
          isOnline == Loading -> CircularProgressIndicator(modifier = Modifier.size(24.dp))
          isOnline -> Text(text = "Online", style = MaterialTheme.typography.bodyMedium)
          !isOnline -> Text(
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
}

@Composable
private fun LoadingView(modifier: Modifier) {
  Column(
    verticalArrangement = Arrangement.spacedBy(4.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier.fillMaxSize()
  ) {
    val composition: Any? = rememberKottieComposition(
      spec = KottieCompositionSpec.Url(Animations.Loading)
    )
    val animationState: KottieAnimationState by animateKottieCompositionAsState(
      composition = composition,
      isPlaying = true,
      iterations = KottieConstants.IterateForever
    )

    Spacer(modifier = Modifier.weight(1f))

    KottieAnimation(
      composition = composition,
      progress = { animationState.progress },
      modifier = Modifier.size(180.dp)
    )

    Text(
      text = "Server is offline",
      style = MaterialTheme.typography.titleLarge,
      fontWeight = FontWeight.Bold
    )

    Text(
      text = "Unable to connect to server. Please come back later",
      textAlign = TextAlign.Center,
      modifier = Modifier.fillMaxWidth(.75f),
    )

    Spacer(modifier = Modifier.weight(1f))
  }
}

private fun LazyGridScope.InvitesView(
  player: Player?,
  invites: Set<Invite>?,
  onAccept: (Invite) -> Unit,
  onDecline: (Invite) -> Unit,
  onWithdraw: (Invite) -> Unit,
) {
  item(span = { GridItemSpan(maxLineSpan) }) {
    Text(
      text = "Invites ${invites?.size?.let { "($it)" }.orEmpty()}",
      style = MaterialTheme.typography.titleMedium
    )
  }

  if (invites == Loading) item(span = { GridItemSpan(maxLineSpan) }) {
    Box(modifier = Modifier.fillMaxWidth()) {
      CircularProgressIndicator(
        modifier = Modifier
          .align(Alignment.Center)
      )
    }
  } else items(invites.toList()) { invite ->
    Card(
      colors = if (invite.from != player) CardDefaults.cardColors(
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
        if (invite.from == player) PlayerAvatar(invite.to)
        else PlayerAvatar(invite.from)

        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
          Text(
            text = if (invite.from == player) invite.to.name else invite.from.name,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold.takeIf { invite.status != REJECTED },
          )

          Text(
            text = when (invite.status) {
              SENT -> if (invite.from == player) "Invite sent" else "Invite received"
              REJECTED -> "Invite rejected"
              ACCEPTED -> "Invite accepted"
            },
            style = MaterialTheme.typography.bodySmall
          )
        }

        Spacer(modifier = Modifier.weight(1f))

        when {
          invite.status == SENT && invite.from != player -> {
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

private fun LazyGridScope.PlayersView(
  player: Player?,
  players: List<Player>?,
  invites: Set<Invite>?,
  onInvite: (Player, Player) -> Unit,
) {
  item(span = { GridItemSpan(maxLineSpan) }) {
    Text(
      text = "Players online ${players?.size?.let { "($it)" }.orEmpty()}",
      style = MaterialTheme.typography.titleMedium
    )
  }

  if (players == Loading || player == Loading || invites == Loading) item(
    span = { GridItemSpan(maxLineSpan) }
  ) {
    Box(modifier = Modifier.fillMaxWidth()) {
      CircularProgressIndicator(
        modifier = Modifier
          .align(Alignment.Center)
      )
    }
  } else items(players) { opponent ->
    val isEnabled =
      // Ignore self invites
      opponent != player && invites.none { it.to == opponent }

    Card(
      onClick = { onInvite(player, opponent) },
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

private fun LazyGridScope.GamesView(
  matches: Set<Match>?,
  onGame: (Match) -> Unit,
) {
  item(span = { GridItemSpan(maxLineSpan) }) {
    Text(
      text = "Games ${matches?.size?.let { "($it)" }.orEmpty()}",
      style = MaterialTheme.typography.titleMedium
    )
  }

  if (matches == Loading) item(span = { GridItemSpan(maxLineSpan) }) {
    Box(modifier = Modifier.fillMaxWidth()) {
      CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
  } else if (matches.isNotEmpty()) item(span = { GridItemSpan(maxLineSpan) }) {
    LazyHorizontalGrid(
      rows = GridCells.Adaptive(256.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp),
      modifier = Modifier.height(256.dp)
    ) {
      items(matches.toList()) { match ->
        MatchView(match, onGame)
      }
    }
  }
}