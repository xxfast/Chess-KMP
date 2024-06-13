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

public val RegularGroup.Bn: ImageVector
  @Composable get() {
    val fill = MaterialTheme.colorScheme.primary

    return Builder(
      name = "Bn", defaultWidth = 1000.0.dp, defaultHeight = 1000.0.dp,
      viewportWidth = 1000.0f, viewportHeight = 1000.0f
    ).apply {
      path(
        fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
        pathFillType = NonZero
      ) {
        moveToRelative(244.0f, 940.0f)
        lineToRelative(0.0f, -2.0f)
        lineToRelative(0.0f, -25.0f)
        lineToRelative(3.0f, -31.0f)
        quadToRelative(3.0f, -30.0f, 16.0f, -54.5f)
        quadToRelative(13.0f, -24.5f, 47.0f, -27.5f)
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
        lineTo(834.0f, 937.0f)
        lineTo(834.0f, 940.0f)
        lineTo(244.0f, 940.0f)
        close()
        moveTo(420.0f, 547.0f)
        quadToRelative(-20.0f, 9.0f, -33.0f, 14.0f)
        quadToRelative(-3.0f, 1.0f, -37.0f, 12.0f)
        lineToRelative(-2.0f, 1.0f)
        lineToRelative(-21.0f, 6.0f)
        lineToRelative(-20.0f, 7.0f)
        quadToRelative(-7.0f, 2.0f, -17.0f, 12.0f)
        lineToRelative(-11.0f, 17.0f)
        lineToRelative(-2.0f, 3.0f)
        lineToRelative(-1.0f, 3.0f)
        lineToRelative(-13.0f, 18.0f)
        quadToRelative(-6.0f, 6.0f, -17.0f, 7.0f)
        lineToRelative(-11.0f, -1.0f)
        lineToRelative(-11.0f, -2.0f)
        quadToRelative(-20.0f, -6.0f, -39.0f, -21.0f)
        quadToRelative(-19.0f, -15.0f, -19.0f, -33.0f)
        quadToRelative(0.0f, -43.0f, 22.0f, -81.0f)
        quadToRelative(21.0f, -40.0f, 50.0f, -67.0f)
        quadToRelative(12.0f, -12.0f, 24.0f, -28.0f)
        quadToRelative(6.0f, -8.0f, 14.0f, -20.0f)
        quadToRelative(16.0f, -29.0f, 16.0f, -62.0f)
        quadToRelative(0.0f, -12.0f, 5.0f, -20.0f)
        lineToRelative(15.0f, -17.0f)
        lineToRelative(13.0f, -10.0f)
        lineToRelative(14.0f, -13.0f)
        lineToRelative(19.0f, -21.0f)
        quadToRelative(8.0f, -11.0f, 16.0f, -30.0f)
        lineToRelative(3.0f, -11.0f)
        lineToRelative(3.0f, -12.0f)
        lineToRelative(0.0f, -2.0f)
        lineToRelative(7.0f, -27.0f)
        quadToRelative(5.0f, -12.0f, 19.0f, -12.0f)
        lineToRelative(19.0f, 19.0f)
        lineToRelative(19.0f, 21.0f)
        lineToRelative(3.0f, 5.0f)
        lineToRelative(4.0f, 5.0f)
        quadToRelative(18.0f, 24.0f, 40.5f, 44.0f)
        quadToRelative(22.5f, 20.0f, 54.5f, 20.0f)
        quadToRelative(12.0f, -0.0f, 46.0f, 11.5f)
        quadToRelative(34.0f, 11.5f, 71.0f, 40.5f)
        quadToRelative(45.0f, 35.0f, 86.0f, 105.0f)
        quadToRelative(20.0f, 34.0f, 30.0f, 77.5f)
        quadTo(789.0f, 549.0f, 789.0f, 606.0f)
        lineToRelative(0.0f, 7.0f)
        lineToRelative(0.0f, 6.0f)
        lineToRelative(0.0f, 18.0f)
        quadToRelative(0.0f, 12.0f, 2.0f, 18.0f)
        lineToRelative(0.0f, 64.0f)
        quadToRelative(0.0f, 25.0f, -17.0f, 25.0f)
        lineToRelative(-1.0f, -0.0f)
        lineToRelative(-1.0f, -0.0f)
        lineToRelative(-6.0f, -0.0f)
        lineToRelative(-5.0f, -1.0f)
        lineToRelative(-118.0f, -12.0f)
        lineToRelative(-102.0f, -4.0f)
        lineToRelative(-84.0f, 3.0f)
        lineToRelative(-72.0f, 7.0f)
        lineToRelative(-38.0f, 4.0f)
        lineToRelative(-35.0f, 3.0f)
        quadToRelative(-7.0f, -0.0f, -10.0f, -2.0f)
        quadToRelative(-3.0f, -3.0f, -3.0f, -8.0f)
        lineToRelative(3.0f, -11.0f)
        lineToRelative(9.0f, -14.0f)
        lineToRelative(12.0f, -12.0f)
        lineToRelative(14.0f, -12.0f)
        lineToRelative(3.0f, -2.0f)
        lineToRelative(3.0f, -3.0f)
        lineToRelative(33.0f, -15.0f)
        quadToRelative(14.0f, -5.0f, 21.0f, -8.0f)
        quadToRelative(7.0f, -3.0f, 22.0f, -11.0f)
        quadToRelative(33.0f, -15.0f, 60.0f, -39.0f)
        quadToRelative(27.0f, -24.0f, 27.0f, -64.0f)
        lineToRelative(-1.0f, -9.0f)
        lineToRelative(-1.0f, -11.0f)
        quadToRelative(-2.0f, -7.0f, -3.0f, -11.0f)
        lineToRelative(-5.0f, -12.5f)
        quadToRelative(0.0f, -0.0f, -8.0f, -11.5f)
        lineToRelative(-3.0f, -0.0f)
        lineToRelative(-3.0f, 2.0f)
        lineToRelative(-3.0f, 3.0f)
        quadToRelative(-24.0f, 40.0f, -59.0f, 54.0f)
        close()
      }
    }
      .build()
  }
