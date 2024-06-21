import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController
import io.github.xxfast.chess.App
import io.github.xxfast.decompose.router.LocalRouterContext
import io.github.xxfast.decompose.router.RouterContext
import platform.UIKit.UIViewController

fun MainViewController(routerContext: RouterContext): UIViewController = ComposeUIViewController {
  CompositionLocalProvider(LocalRouterContext provides routerContext) {
    App()
  }
}
