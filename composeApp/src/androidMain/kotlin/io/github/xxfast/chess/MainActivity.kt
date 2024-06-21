package io.github.xxfast.chess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import io.github.xxfast.decompose.router.LocalRouterContext
import io.github.xxfast.decompose.router.RouterContext
import io.github.xxfast.decompose.router.defaultRouterContext

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    val rootRouterContext: RouterContext = defaultRouterContext()

    setContent {
      CompositionLocalProvider(LocalRouterContext provides rootRouterContext) {
        with(ChessApplication){ RootScreen() }
      }
    }
  }
}

