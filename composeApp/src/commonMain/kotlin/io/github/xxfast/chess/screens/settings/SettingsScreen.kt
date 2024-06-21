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
import androidx.compose.material.icons.rounded.Warning
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
import io.github.xxfast.decompose.router.rememberOnRoute
import kotlin.reflect.KFunction1

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
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsView(
  state: SettingsState,
  onBack: () -> Unit,
  onUpdateUsername: (String) -> Unit,
) {
  val scrollBehavior: TopAppBarScrollBehavior =
    TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

  var showUsernameDialog: Boolean by remember { mutableStateOf(false) }
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
    }
  }
}

@Composable
fun SettingsItem(
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
      Icon(Icons.Rounded.Person, null)
      Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        ProvideTextStyle(MaterialTheme.typography.labelMedium) { label() }
        value()
      }
    }
  }
}
