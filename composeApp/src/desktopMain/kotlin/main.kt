import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.github.xxfast.chess.App

fun main() = application {
  Window(
    onCloseRequest = ::exitApplication,
    title = "Chess-KMP",
  ) {
    App()
  }
}
