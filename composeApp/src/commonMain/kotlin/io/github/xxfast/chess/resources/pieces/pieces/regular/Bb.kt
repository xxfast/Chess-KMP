package io.github.xxfast.chess.resources.pieces.pieces.regular

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import io.github.xxfast.chess.resources.pieces.pieces.RegularGroup

public val RegularGroup.Bb: ImageVector
  @Composable get() {
    val fill = MaterialTheme.colorScheme.primary

    return Builder(
      name = "Bb", defaultWidth = 1000.0.dp, defaultHeight = 1000.0.dp,
      viewportWidth = 1000.0f, viewportHeight = 1000.0f
    ).apply {
      path(
        fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
        pathFillType = NonZero
      ) {
        moveTo(877.0f, 940.0f)
        lineTo(592.0f, 940.0f)
        quadToRelative(-21.0f, -0.0f, -35.0f, -11.0f)
        lineToRelative(-21.0f, -25.0f)
        lineToRelative(-2.0f, -3.0f)
        lineToRelative(-8.0f, -13.0f)
        lineToRelative(-6.0f, -11.0f)
        lineToRelative(-10.0f, -11.0f)
        lineToRelative(-9.0f, -4.0f)
        quadToRelative(-8.0f, 2.0f, -10.0f, 4.0f)
        lineToRelative(-8.0f, 8.0f)
        lineToRelative(-9.0f, 12.0f)
        lineToRelative(-9.0f, 15.0f)
        lineToRelative(-2.0f, 3.0f)
        quadTo(454.0f, 916.0f, 438.0f, 929.0f)
        quadTo(422.0f, 940.0f, 399.0f, 940.0f)
        lineTo(125.0f, 940.0f)
        lineTo(92.0f, 792.0f)
        lineToRelative(226.0f, -0.0f)
        quadToRelative(10.0f, -0.0f, 13.0f, -7.0f)
        lineToRelative(4.0f, -18.0f)
        lineToRelative(0.0f, -2.0f)
        lineToRelative(0.0f, -5.0f)
        lineToRelative(1.0f, -5.0f)
        quadToRelative(2.0f, -9.0f, 6.5f, -16.0f)
        quadToRelative(4.5f, -7.0f, 17.5f, -8.0f)
        lineToRelative(304.0f, -0.0f)
        quadToRelative(6.0f, -0.0f, 9.0f, 7.0f)
        lineToRelative(4.0f, 13.0f)
        lineToRelative(0.0f, 6.0f)
        lineToRelative(0.0f, 4.0f)
        lineToRelative(0.0f, 3.0f)
        lineToRelative(0.0f, 6.0f)
        quadToRelative(0.0f, 10.0f, 2.0f, 15.0f)
        quadToRelative(1.0f, 6.0f, 8.0f, 7.0f)
        lineToRelative(222.0f, -0.0f)
        close()
        moveTo(515.0f, 486.0f)
        lineTo(516.0f, 470.0f)
        quadToRelative(0.0f, -10.0f, 2.0f, -16.0f)
        lineToRelative(3.0f, -26.0f)
        lineToRelative(6.0f, -31.0f)
        lineToRelative(3.0f, -12.0f)
        lineToRelative(3.0f, -12.0f)
        quadToRelative(5.0f, -14.0f, 8.5f, -23.0f)
        quadToRelative(3.5f, -9.0f, 13.0f, -25.5f)
        quadToRelative(9.5f, -16.5f, 26.5f, -34.5f)
        quadToRelative(36.0f, 6.0f, 68.0f, 47.5f)
        quadToRelative(32.0f, 41.5f, 54.0f, 92.5f)
        lineToRelative(13.0f, 45.0f)
        lineToRelative(5.0f, 39.0f)
        quadToRelative(0.0f, 79.0f, -14.0f, 111.0f)
        quadToRelative(-12.0f, 33.0f, -30.0f, 45.0f)
        quadToRelative(-8.0f, 5.0f, -19.0f, 7.0f)
        lineToRelative(-15.0f, 1.0f)
        lineToRelative(-2.0f, -0.0f)
        lineToRelative(-262.0f, -0.0f)
        lineToRelative(-2.0f, -0.0f)
        lineToRelative(-20.0f, -1.0f)
        quadToRelative(-10.0f, -0.0f, -23.0f, -7.0f)
        quadToRelative(-19.0f, -10.0f, -36.5f, -44.5f)
        quadTo(280.0f, 591.0f, 280.0f, 514.0f)
        quadToRelative(0.0f, -61.0f, 25.0f, -106.0f)
        quadToRelative(25.0f, -45.0f, 54.5f, -77.0f)
        quadToRelative(29.5f, -32.0f, 54.0f, -50.5f)
        quadTo(438.0f, 262.0f, 439.0f, 254.0f)
        lineToRelative(-2.0f, -13.0f)
        lineToRelative(-3.0f, -13.0f)
        lineToRelative(-1.0f, -3.0f)
        lineToRelative(-5.0f, -19.0f)
        lineToRelative(-2.0f, -17.0f)
        quadToRelative(0.0f, -25.0f, 15.0f, -45.5f)
        quadToRelative(15.0f, -20.5f, 50.0f, -20.5f)
        quadToRelative(23.0f, -0.0f, 40.5f, 18.5f)
        quadTo(549.0f, 160.0f, 553.0f, 184.0f)
        lineToRelative(1.0f, 6.0f)
        lineToRelative(0.0f, 6.0f)
        quadToRelative(0.0f, 25.0f, -10.0f, 48.0f)
        lineToRelative(-21.0f, 45.0f)
        lineToRelative(-6.0f, 9.0f)
        lineToRelative(-4.0f, 9.0f)
        lineToRelative(-24.0f, 45.0f)
        quadTo(478.0f, 373.0f, 474.5f, 392.5f)
        quadTo(471.0f, 412.0f, 469.0f, 424.5f)
        quadTo(467.0f, 437.0f, 466.0f, 445.0f)
        lineToRelative(0.0f, 41.0f)
        lineToRelative(49.0f, -0.0f)
        close()
      }
    }
      .build()
  }
