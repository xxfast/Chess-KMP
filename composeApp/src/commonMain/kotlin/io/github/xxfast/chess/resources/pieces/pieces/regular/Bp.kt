package io.github.xxfast.chess.resources.pieces.pieces.regular

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import io.github.xxfast.chess.resources.pieces.pieces.RegularGroup

public val RegularGroup.Bp: ImageVector
  @Composable get() {
    val primary: Color = MaterialTheme.colorScheme.primary

    return remember(primary) {
      Builder(
        name = "Bp", defaultWidth = 1000.0.dp, defaultHeight = 1000.0.dp,
        viewportWidth = 1000.0f, viewportHeight = 1000.0f
      ).apply {
        path(
          fill = SolidColor(primary), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(257.0f, 940.0f)
          lineToRelative(-3.0f, -20.0f)
          lineToRelative(-1.0f, -19.0f)
          quadToRelative(0.0f, -42.0f, 16.0f, -70.0f)
          quadToRelative(9.0f, -16.0f, 17.5f, -26.5f)
          quadTo(295.0f, 794.0f, 307.0f, 783.0f)
          lineToRelative(6.0f, -5.0f)
          lineToRelative(7.0f, -5.0f)
          quadToRelative(20.0f, -16.0f, 39.5f, -25.0f)
          quadToRelative(19.5f, -9.0f, 21.5f, -13.0f)
          lineToRelative(-1.0f, -7.0f)
          lineToRelative(0.0f, -8.0f)
          lineToRelative(3.0f, -28.0f)
          lineToRelative(9.0f, -28.0f)
          quadToRelative(15.0f, -33.0f, 41.5f, -56.5f)
          quadTo(460.0f, 584.0f, 491.0f, 578.0f)
          lineToRelative(5.0f, -1.0f)
          lineToRelative(5.0f, -0.0f)
          lineToRelative(7.0f, 1.0f)
          lineToRelative(7.0f, -0.0f)
          quadToRelative(27.0f, 6.0f, 53.0f, 30.0f)
          quadToRelative(26.0f, 24.0f, 41.0f, 56.0f)
          lineToRelative(7.0f, 21.0f)
          lineToRelative(4.0f, 21.0f)
          lineToRelative(1.0f, 7.0f)
          lineToRelative(0.0f, 7.0f)
          lineToRelative(0.0f, 8.0f)
          lineToRelative(-1.0f, 7.0f)
          lineToRelative(21.0f, 13.0f)
          quadToRelative(18.0f, 8.0f, 43.0f, 27.0f)
          lineToRelative(5.0f, 4.0f)
          lineToRelative(6.0f, 4.0f)
          quadToRelative(20.0f, 17.0f, 37.0f, 47.0f)
          quadToRelative(17.0f, 30.0f, 17.0f, 72.0f)
          lineTo(748.0f, 921.0f)
          lineTo(745.0f, 940.0f)
          lineTo(257.0f, 940.0f)
          close()
          moveTo(433.0f, 393.0f)
          quadToRelative(28.0f, -28.0f, 68.0f, -28.0f)
          quadToRelative(39.0f, -0.0f, 67.0f, 28.0f)
          quadToRelative(28.0f, 28.0f, 28.0f, 67.0f)
          quadToRelative(0.0f, 39.0f, -28.0f, 67.0f)
          quadToRelative(-28.0f, 28.0f, -67.0f, 28.0f)
          quadToRelative(-39.0f, -0.0f, -67.0f, -27.5f)
          quadToRelative(-28.0f, -27.5f, -28.0f, -67.5f)
          quadToRelative(0.0f, -38.0f, 27.0f, -67.0f)
          close()
        }
      }
        .build()
    }

  }
