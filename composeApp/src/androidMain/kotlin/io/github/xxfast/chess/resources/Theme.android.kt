package io.github.xxfast.chess.resources

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun ChessTheme(content: @Composable () -> Unit) {
  MaterialTheme(
    colorScheme = when {
      isSystemInDarkTheme() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> dynamicDarkColorScheme(LocalContext.current)
      isSystemInDarkTheme() -> darkColorScheme()
      Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> dynamicLightColorScheme(LocalContext.current)
      else -> lightColorScheme()
    }
  ) {
    content()
  }
}
