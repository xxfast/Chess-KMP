package io.github.xxfast.chess

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.androidPredictiveBackAnimatable
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.predictiveBackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import io.github.xxfast.chess.discovery.Match
import io.github.xxfast.chess.resources.ChessTheme
import io.github.xxfast.chess.screens.game.GameScreen
import io.github.xxfast.chess.screens.matchmake.MatchMakingScreen
import io.github.xxfast.chess.screens.settings.SettingsScreen
import io.github.xxfast.decompose.router.LocalRouterContext
import io.github.xxfast.decompose.router.stack.RoutedContent
import io.github.xxfast.decompose.router.stack.Router
import io.github.xxfast.decompose.router.stack.rememberRouter

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun ChessApplicationScope.RootScreen() {
  val router: Router<RootScreens> = rememberRouter(RootScreens::class) {
    listOf(RootScreens.MatchMaking)
  }

  ChessTheme {
    RoutedContent(
      router = router,
      animation = predictiveBackAnimation(
        fallbackAnimation = stackAnimation(fade() + scale()),
        selector = { backEvent, _, _ -> androidPredictiveBackAnimatable(backEvent) },
        backHandler = LocalRouterContext.current.backHandler,
        onBack = { router.pop() }
      ),
      modifier = Modifier.fillMaxSize()
    ) { screen ->
      when (screen) {
        is RootScreens.MatchMaking -> MatchMakingScreen(
          onSettings = { router.push(RootScreens.Settings) },
          onGame = { match: Match -> router.push(RootScreens.Game(match)) }
        )

        is RootScreens.Settings -> SettingsScreen(
          onBack = { router.pop() }
        )

        is RootScreens.Game -> GameScreen(
          onClose = { router.pop() }
        )
      }
    }
  }
}
