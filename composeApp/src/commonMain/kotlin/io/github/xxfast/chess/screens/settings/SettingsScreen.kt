package io.github.xxfast.chess.screens.settings

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Public
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ProvideTextStyle
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.chess.matchmaking.Address
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
fun ChessApplicationScope.SettingsScreen(
  onBack: () -> Unit,
) {
  val viewModel: SettingsViewModel =
    rememberOnRoute(SettingsViewModel::class) { routerContext -> SettingsViewModel(this, routerContext) }

  val state: SettingsState by viewModel.state.collectAsState()

  SettingsView(
    state = state,
    onBack = onBack,
    onUpdateUsername = viewModel::onUpdateUsername,
    onUpdateAddress = viewModel::onUpdateAddress
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsView(
  state: SettingsState,
  onBack: () -> Unit,
  onUpdateUsername: (String) -> Unit,
  onUpdateAddress: (Address) -> Unit,
) {
  val scrollBehavior: TopAppBarScrollBehavior =
    TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

  var showUsernameDialog: Boolean by remember { mutableStateOf(false) }
  var showAddressDialog: Boolean by remember { mutableStateOf(false) }

  if (state.player != Loading && showUsernameDialog) {
    var username: String by remember { mutableStateOf(state.player.name) }
    AlertDialog(
      onDismissRequest = { showUsernameDialog = false },
      title = { Text("Username") },
      confirmButton = {
        TextButton(
          onClick = {
            onUpdateUsername(username)
            showUsernameDialog = false
          }
        ) { Text("Ok") }
      },
      text = {
        OutlinedTextField(
          value = username,
          onValueChange = { username = it },
          label = { Text("Username") },
          keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        )
      },
      properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    )
  }

  if(state.serverAddress != Loading && showAddressDialog){
    var address: String by remember(state) { mutableStateOf(state.serverAddress.host) }
    var port: Int by remember(state) { mutableStateOf(state.serverAddress.port) }

    AlertDialog(
      onDismissRequest = { showAddressDialog = false },
      title = { Text("Address") },
      confirmButton = {
        TextButton(
          onClick = {
            onUpdateAddress(Address(address, port))
            showAddressDialog = false
          }
        ) { Text("Ok") }
      },
      text = {
        val errorText: @Composable () -> Unit = { Text("Please enter a valid address") }

        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
          OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            isError = address.isBlank(),
            supportingText = errorText.takeIf { address.isBlank() },
            label = { Text("Address") },
            modifier = Modifier.fillMaxWidth().weight(.75f),
          )

          OutlinedTextField(
            value = "$port",
            onValueChange = { port = it.toInt() },
            label = { Text("Port") },
            modifier = Modifier.fillMaxWidth().weight(.25f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
          )
        }
      },
      properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    )
  }

  Scaffold(
    topBar = {
      LargeTopAppBar(
        title = { Text("Settings") },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
          }
        },
        scrollBehavior = scrollBehavior
      )
    },
  ) { scaffoldPadding ->
    LazyColumn(
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      modifier = Modifier
        .padding(scaffoldPadding)
        .fillMaxSize()
        .nestedScroll(scrollBehavior.nestedScrollConnection)
        .imePadding()
    ) {
      item {
        Text(
          text = "Account",
          style = MaterialTheme.typography.titleMedium,
        )
      }

      item {
        SettingsItem(
          onClick = { showUsernameDialog = true },
          icon = { Icon(Icons.Rounded.Person, null) },
          label = { Text(text = "Username", fontWeight = FontWeight.Bold) },
          value = {
            AnimatedContent(
              targetState = state.player,
              transitionSpec = { fadeIn() togetherWith fadeOut() },
            ) { player ->
              if (player == Loading)
                CircularProgressIndicator(modifier = Modifier.size(12.dp))
              else Text(
                text = player.name,
                style = MaterialTheme.typography.bodyLarge
              )
            }
          }
        )
      }

      item {
        Text(
          text = "Server",
          style = MaterialTheme.typography.titleMedium,
        )
      }

      item {
        SettingsItem(
          onClick = { showAddressDialog = true },
          icon = { Icon(Icons.Rounded.Public, null) },
          label = { Text(text = "Address", fontWeight = FontWeight.Bold) },
          value = {
            AnimatedContent(
              targetState = state.serverAddress,
              transitionSpec = { fadeIn() togetherWith fadeOut() },
            ) { address ->
              if (address == Loading)
                CircularProgressIndicator(modifier = Modifier.size(12.dp))
              else Text(
                text = address.value,
                style = MaterialTheme.typography.bodyLarge
              )
            }
          }
        )
      }

      item {

      }
    }
  }
}

@Composable
fun SettingsItem(
  icon: @Composable () -> Unit,
  label: @Composable () -> Unit,
  value: @Composable () -> Unit,
  onClick: () -> Unit
) {
  Card(
    onClick = onClick,
    modifier = Modifier.fillMaxWidth()
  ) {
    Row(
      horizontalArrangement = Arrangement.spacedBy(16.dp),
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.padding(16.dp).fillMaxWidth(),
    ) {
      icon()
      Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        ProvideTextStyle(MaterialTheme.typography.labelMedium) { label() }
        value()
      }
    }
  }
}
