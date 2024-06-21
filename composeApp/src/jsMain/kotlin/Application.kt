import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import io.github.xxfast.chess.App
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
        App()
      }
    }
  }
}
