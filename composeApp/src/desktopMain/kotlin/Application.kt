import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import io.github.xxfast.chess.App
import io.github.xxfast.decompose.router.LocalRouterContext
import io.github.xxfast.decompose.router.RouterContext
import io.github.xxfast.decompose.router.defaultRouterContext

fun main() = application {
  val windowState: WindowState = rememberWindowState()
  val rootRouterContext: RouterContext = defaultRouterContext(windowState = windowState)

  Window(
    onCloseRequest = ::exitApplication,
    title = "Chess-KMP",
  ) {
    CompositionLocalProvider(LocalRouterContext provides rootRouterContext) {
      App()
    }
  }
}
