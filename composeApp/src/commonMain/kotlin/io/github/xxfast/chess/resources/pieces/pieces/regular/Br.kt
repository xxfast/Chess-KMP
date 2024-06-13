package io.github.xxfast.chess.resources.pieces.pieces.regular

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
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

public val RegularGroup.Br: ImageVector
  @Composable get() {
    val fill = MaterialTheme.colorScheme.primary
    return Builder(
      name = "Br", defaultWidth = 1000.0.dp, defaultHeight = 1000.0.dp,
      viewportWidth = 1000.0f, viewportHeight = 1000.0f
    ).apply {
      path(
        fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
        pathFillType = NonZero
      ) {
        moveToRelative(199.0f, 940.0f)
        lineToRelative(0.0f, -2.0f)
        lineToRelative(0.0f, -25.0f)
        lineToRelative(3.0f, -31.0f)
        quadToRelative(3.0f, -30.0f, 16.0f, -54.5f)
        quadToRelative(13.0f, -24.5f, 47.0f, -27.5f)
        lineToRelative(35.0f, -3.0f)
        lineToRelative(40.0f, -4.0f)
        lineToRelative(74.0f, -7.0f)
        lineToRelative(86.0f, -3.0f)
        quadToRelative(23.0f, -0.0f, 49.0f, 1.0f)
        quadToRelative(26.0f, 1.0f, 55.0f, 4.0f)
        quadToRelative(32.0f, -0.0f, 69.0f, 5.0f)
        quadToRelative(37.0f, 5.0f, 63.0f, 8.0f)
        quadToRelative(26.0f, 3.0f, 39.0f, 34.0f)
        quadToRelative(3.0f, 8.0f, 8.0f, 26.0f)
        quadToRelative(5.0f, 18.0f, 5.0f, 39.0f)
        lineToRelative(1.0f, 19.0f)
        lineTo(789.0f, 937.0f)
        lineTo(789.0f, 940.0f)
        lineTo(199.0f, 940.0f)
        close()
        moveTo(318.0f, 509.0f)
        quadToRelative(25.0f, -7.0f, 76.0f, -13.0f)
        quadToRelative(51.0f, -6.0f, 106.0f, -6.0f)
        quadToRelative(53.0f, -0.0f, 104.0f, 5.5f)
        quadToRelative(51.0f, 5.5f, 83.0f, 13.5f)
        lineToRelative(34.0f, 235.0f)
        lineToRelative(-119.0f, -12.0f)
        quadToRelative(-23.0f, -0.0f, -59.5f, -2.5f)
        quadTo(506.0f, 727.0f, 500.0f, 727.0f)
        lineToRelative(-87.0f, 3.0f)
        lineToRelative(-72.0f, 7.0f)
        lineToRelative(-34.0f, 4.0f)
        lineToRelative(-27.0f, 3.0f)
        close()
        moveTo(419.0f, 340.0f)
        lineTo(438.0f, 228.0f)
        lineToRelative(7.0f, -0.0f)
        lineToRelative(8.0f, -2.0f)
        lineToRelative(23.0f, -2.0f)
        lineToRelative(24.0f, -1.0f)
        lineToRelative(20.0f, 1.0f)
        lineToRelative(20.0f, 1.0f)
        lineToRelative(10.0f, 2.0f)
        lineToRelative(10.0f, 1.0f)
        lineToRelative(17.0f, 112.0f)
        lineToRelative(52.0f, -0.0f)
        lineToRelative(34.0f, -97.0f)
        lineToRelative(20.0f, 3.0f)
        lineToRelative(21.0f, 3.0f)
        lineToRelative(20.0f, 6.0f)
        lineToRelative(21.0f, 9.0f)
        lineToRelative(-6.0f, 98.0f)
        quadTo(736.0f, 391.0f, 723.5f, 413.5f)
        quadTo(711.0f, 436.0f, 687.0f, 454.0f)
        lineToRelative(-26.0f, -3.0f)
        lineToRelative(-26.0f, -4.0f)
        lineToRelative(-61.0f, -7.0f)
        lineToRelative(-74.0f, -4.0f)
        quadToRelative(-19.0f, -0.0f, -40.5f, 1.0f)
        quadToRelative(-21.5f, 1.0f, -43.5f, 4.0f)
        quadToRelative(-18.0f, -0.0f, -41.5f, 3.5f)
        quadTo(351.0f, 448.0f, 318.0f, 454.0f)
        quadTo(291.0f, 440.0f, 279.5f, 420.0f)
        quadTo(268.0f, 400.0f, 263.0f, 374.0f)
        lineToRelative(-10.0f, -110.0f)
        lineToRelative(22.0f, -9.0f)
        lineToRelative(25.0f, -7.0f)
        lineToRelative(19.0f, -3.0f)
        lineToRelative(18.0f, -2.0f)
        lineToRelative(34.0f, 97.0f)
        lineToRelative(48.0f, -0.0f)
        close()
      }
    }
      .build()
  }
