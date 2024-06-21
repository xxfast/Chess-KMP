package io.github.xxfast.chess.screens.matchmake

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import io.github.xxfast.chess.discover.Player
import io.github.xxfast.chess.resources.pieces.Pieces
import io.github.xxfast.chess.resources.pieces.pieces.Regular
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wn
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
fun MatchMakingScreen() {
  val viewModel: MatchMakingViewModel =
    rememberOnRoute(MatchMakingViewModel::class) { MatchMakingViewModel() }

  val state: MatchMakingState by viewModel.state.collectAsState()

  MatchMakingView(
    state = state,
    onJoin = viewModel::onJoin,
    onLeave = viewModel::onLeave,
    onMatch = viewModel::onMatch,
    onEditProfile = { TODO() }
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchMakingView(
  state: MatchMakingState,
  onJoin: (String, Int) -> Unit,
  onLeave: (ServerState) -> Unit,
  onMatch: (Player) -> Unit,
  onEditProfile: () -> Unit,
) {
  var showErrorDialog: Boolean by remember { mutableStateOf(false) }

  if (showErrorDialog) AlertDialog(
    onDismissRequest = { showErrorDialog = false },
    confirmButton = {},
    icon = { Icon(Icons.Rounded.Warning, contentDescription = null) },
    title = { Text("Unable to reach the server") },
    text = { Text("Please check your internet connection.") },
  )

  val scrollBehavior: TopAppBarScrollBehavior =
    TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

  Scaffold(
    topBar = {
      LargeTopAppBar(
        title = { Text("Chess-KMP") },
        actions = {
          IconButton(onClick = onEditProfile) {
            if (state.player == null) CircularProgressIndicator()
            else PlayerAvatar(player = state.player)
          }
        },
        scrollBehavior = scrollBehavior
      )
    },
  ) { scaffoldPadding ->
    LazyVerticalGrid(
      columns = GridCells.Adaptive(128.dp),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp),
      modifier = Modifier
        .padding(scaffoldPadding)
        .fillMaxSize()
        .nestedScroll(scrollBehavior.nestedScrollConnection)
        .imePadding()
    ) {
      item(span = { GridItemSpan(maxLineSpan) }) {
        var address: String by rememberSaveable { mutableStateOf("10.0.2.2") }
        var port: String by rememberSaveable { mutableStateOf("8080") }

        OutlinedCard(
          shape = MaterialTheme.shapes.extraLarge,
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
              .fillMaxWidth()
              .padding(8.dp),
          ) {
            Text("Server details", style = MaterialTheme.typography.titleMedium)

            Row(
              horizontalArrangement = Arrangement.spacedBy(8.dp),
              modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
            ) {
              val errorText: @Composable () -> Unit = { Text("Please enter a valid address") }

              OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                enabled = state.server == None,
                isError = address.isBlank(),
                supportingText = errorText.takeIf { address.isBlank() },
                label = { Text("Address") },
                modifier = Modifier.fillMaxWidth().weight(.75f),
                shape = MaterialTheme.shapes.extraLarge,
              )

              OutlinedTextField(
                value = port,
                onValueChange = { port = it },
                enabled = state.server == None,
                label = { Text("Port") },
                modifier = Modifier.fillMaxWidth().weight(.25f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                shape = MaterialTheme.shapes.extraLarge,
              )
            }

            Button(
              onClick = {
                if (state.server == None) onJoin(address, port.toInt())
                else onLeave(state.server)
              },
            ) {
              if (state.server == None) Text("Join")
              else Text("Leave")
            }
          }
        }
      }

      if (state.server == None) return@LazyVerticalGrid
      item(span = { GridItemSpan(maxLineSpan) }) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
        ) {
          Text(
            text = "${state.server.name} ${
              state.server.players?.let { "(${it.size})" }.orEmpty()
            }",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(8.dp)
          )

          Spacer(modifier = Modifier.weight(1f))

          Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
          ) {
            Box(
              modifier = Modifier
                .size(8.dp)
                .background(
                  color = if (state.server.isOnline) MaterialTheme.colorScheme.primary
                  else MaterialTheme.colorScheme.error,
                  shape = CircleShape
                )
            )

            Text(
              text = if (state.server.isOnline) "Online"
              else "Offline"
            )
          }
        }
      }

      if (state.server.isOnline && state.server.players == Loading) item(span = {
        GridItemSpan(
          maxLineSpan
        )
      }) {
        Box(modifier = Modifier.fillMaxWidth()) {
          CircularProgressIndicator(
            modifier = Modifier
              .align(Alignment.Center)
          )
        }
      } else items(state.server.players.orEmpty()) { opponent ->
        Card(
          onClick = { onMatch(opponent) },
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
              .padding(8.dp)
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
  }
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
