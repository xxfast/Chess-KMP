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

public val RegularGroup.Bq: ImageVector
  @Composable get() {
    val fill = MaterialTheme.colorScheme.primary

    return Builder(
      name = "Bq", defaultWidth = 1000.0.dp, defaultHeight = 1000.0.dp,
      viewportWidth = 1000.0f, viewportHeight = 1000.0f
    ).apply {
      path(
        fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
        pathFillType = NonZero
      ) {
        moveToRelative(209.0f, 940.0f)
        lineToRelative(0.0f, -2.0f)
        lineToRelative(0.0f, -26.0f)
        quadToRelative(0.0f, -20.0f, 2.5f, -39.5f)
        quadToRelative(2.5f, -19.5f, 14.5f, -44.5f)
        quadToRelative(12.0f, -25.0f, 41.0f, -28.0f)
        lineToRelative(35.0f, -3.0f)
        lineToRelative(38.0f, -4.0f)
        lineToRelative(72.0f, -7.0f)
        lineToRelative(85.0f, -3.0f)
        quadToRelative(22.0f, -0.0f, 49.5f, 1.0f)
        quadToRelative(27.5f, 1.0f, 57.5f, 4.0f)
        quadToRelative(34.0f, -0.0f, 71.0f, 5.0f)
        quadToRelative(37.0f, 5.0f, 63.0f, 8.0f)
        quadToRelative(26.0f, 3.0f, 39.0f, 34.0f)
        quadToRelative(3.0f, 8.0f, 8.0f, 26.0f)
        quadToRelative(5.0f, 18.0f, 5.0f, 39.0f)
        lineToRelative(1.0f, 19.0f)
        lineTo(791.0f, 937.0f)
        lineTo(791.0f, 940.0f)
        lineTo(209.0f, 940.0f)
        close()
        moveTo(775.0f, 423.0f)
        lineTo(763.0f, 404.0f)
        lineTo(759.0f, 379.0f)
        quadToRelative(0.0f, -27.0f, 21.0f, -49.0f)
        quadToRelative(21.0f, -22.0f, 50.0f, -22.0f)
        quadToRelative(27.0f, -0.0f, 49.5f, 21.5f)
        quadTo(902.0f, 351.0f, 902.0f, 379.0f)
        quadTo(902.0f, 407.0f, 883.5f, 426.5f)
        quadTo(865.0f, 446.0f, 838.0f, 451.0f)
        lineToRelative(-108.0f, 293.0f)
        lineToRelative(-125.0f, -12.0f)
        lineToRelative(-106.0f, -5.0f)
        lineToRelative(-85.0f, 3.0f)
        lineToRelative(-72.0f, 7.0f)
        lineToRelative(-38.0f, 4.0f)
        lineToRelative(-35.0f, 3.0f)
        lineToRelative(-106.0f, -294.0f)
        quadToRelative(-25.0f, -0.0f, -45.5f, -21.5f)
        quadTo(97.0f, 407.0f, 97.0f, 379.0f)
        quadTo(97.0f, 352.0f, 118.5f, 329.5f)
        quadTo(140.0f, 307.0f, 169.0f, 307.0f)
        quadTo(197.0f, 307.0f, 218.5f, 328.5f)
        quadTo(240.0f, 350.0f, 240.0f, 379.0f)
        lineToRelative(0.0f, 3.0f)
        lineToRelative(-4.0f, 16.0f)
        quadToRelative(-3.0f, 10.0f, -13.0f, 24.0f)
        lineToRelative(103.0f, 117.0f)
        lineToRelative(43.0f, -208.0f)
        quadToRelative(-21.0f, -0.0f, -38.5f, -21.5f)
        quadTo(313.0f, 288.0f, 313.0f, 261.0f)
        quadToRelative(0.0f, -32.0f, 23.0f, -54.0f)
        quadToRelative(23.0f, -22.0f, 53.0f, -22.0f)
        quadToRelative(30.0f, -0.0f, 53.0f, 21.5f)
        quadToRelative(23.0f, 21.5f, 23.0f, 54.5f)
        lineToRelative(-1.0f, 7.0f)
        lineToRelative(0.0f, 7.0f)
        quadTo(461.0f, 288.0f, 453.0f, 300.5f)
        quadTo(445.0f, 313.0f, 430.0f, 322.0f)
        lineToRelative(71.0f, 206.0f)
        lineToRelative(70.0f, -206.0f)
        quadToRelative(-13.0f, -10.0f, -21.5f, -26.5f)
        quadToRelative(-8.5f, -16.5f, -8.5f, -34.5f)
        quadToRelative(0.0f, -32.0f, 23.0f, -54.0f)
        quadToRelative(23.0f, -22.0f, 53.0f, -22.0f)
        quadToRelative(30.0f, -0.0f, 53.0f, 21.5f)
        quadToRelative(23.0f, 21.5f, 23.0f, 54.5f)
        quadToRelative(0.0f, 27.0f, -14.0f, 44.0f)
        quadToRelative(-14.0f, 17.0f, -38.0f, 26.0f)
        lineToRelative(35.0f, 208.0f)
        close()
      }
    }
      .build()
  }

