import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import io.github.xxfast.chess.ChessApplication
import io.github.xxfast.chess.PlatformScope
import io.github.xxfast.chess.RootScreen
import io.github.xxfast.decompose.router.LocalRouterContext
import io.github.xxfast.decompose.router.RouterContext
import io.github.xxfast.decompose.router.defaultRouterContext
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
  onWasmReady {
    val rootRouterContext: RouterContext = defaultRouterContext()
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
      CompositionLocalProvider(LocalRouterContext provides rootRouterContext) {
        with(PlatformScope().ChessApplication) { RootScreen() }
      }
    }
  }
}
