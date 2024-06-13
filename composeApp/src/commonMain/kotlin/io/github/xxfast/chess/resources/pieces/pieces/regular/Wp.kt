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

public val RegularGroup.Wp: ImageVector
  @Composable get() {
    val stroke: Color = MaterialTheme.colorScheme.primary
    val fill: Color = MaterialTheme.colorScheme.surface

    return remember(stroke, fill) {
      Builder(
        name = "Wp", defaultWidth = 1000.0.dp, defaultHeight = 1000.0.dp,
        viewportWidth = 1000.0f, viewportHeight = 1000.0f
      ).apply {
        path(
          fill = SolidColor(stroke),
          stroke = null,
          strokeLineWidth = 0.0f,
          strokeLineCap = Butt,
          strokeLineJoin = Miter,
          strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(240.0f, 940.0f)
          quadToRelative(0.0f, -71.0f, 26.5f, -125.0f)
          quadToRelative(26.5f, -54.0f, 78.5f, -91.0f)
          quadToRelative(12.0f, -8.0f, 15.0f, -23.0f)
          lineToRelative(4.0f, -32.0f)
          lineToRelative(0.0f, -5.0f)
          lineToRelative(0.0f, -4.0f)
          lineToRelative(1.0f, -18.0f)
          quadToRelative(0.0f, -9.0f, 4.0f, -16.0f)
          lineToRelative(9.0f, -14.0f)
          lineToRelative(14.0f, -14.0f)
          lineToRelative(2.0f, -2.0f)
          lineToRelative(18.0f, -20.0f)
          quadToRelative(9.0f, -9.0f, 9.0f, -22.0f)
          quadToRelative(0.0f, -10.0f, -7.0f, -21.0f)
          lineToRelative(-15.0f, -27.0f)
          lineToRelative(-16.0f, -33.0f)
          quadToRelative(-6.0f, -18.0f, -6.0f, -37.0f)
          quadToRelative(0.0f, -47.0f, 37.5f, -81.5f)
          quadTo(452.0f, 320.0f, 501.0f, 320.0f)
          quadTo(549.0f, 320.0f, 586.5f, 354.5f)
          quadTo(624.0f, 389.0f, 624.0f, 436.0f)
          quadTo(624.0f, 453.0f, 618.0f, 472.5f)
          quadTo(612.0f, 492.0f, 602.0f, 506.0f)
          lineToRelative(-15.0f, 27.0f)
          quadToRelative(-1.0f, 2.0f, -4.0f, 10.5f)
          quadToRelative(-3.0f, 8.5f, -3.0f, 10.5f)
          quadToRelative(0.0f, 13.0f, 8.0f, 22.0f)
          lineToRelative(19.0f, 20.0f)
          lineToRelative(2.0f, 2.0f)
          lineToRelative(14.0f, 14.0f)
          quadToRelative(7.0f, 6.0f, 9.0f, 14.0f)
          lineToRelative(4.0f, 18.0f)
          lineToRelative(1.0f, 23.0f)
          lineToRelative(0.0f, 5.0f)
          lineToRelative(0.0f, 4.0f)
          quadToRelative(0.0f, 15.0f, 4.0f, 27.5f)
          quadToRelative(4.0f, 12.5f, 15.0f, 20.5f)
          quadToRelative(49.0f, 34.0f, 77.0f, 89.0f)
          quadToRelative(14.0f, 28.0f, 21.0f, 58.0f)
          quadToRelative(7.0f, 30.0f, 7.0f, 69.0f)
          lineTo(240.0f, 940.0f)
          close()
          moveTo(690.0f, 869.0f)
          quadToRelative(0.0f, -28.0f, -16.0f, -48.0f)
          quadToRelative(-16.0f, -20.0f, -37.0f, -36.0f)
          lineToRelative(-25.0f, -19.0f)
          lineToRelative(-19.0f, -17.0f)
          quadToRelative(-5.0f, -5.0f, -8.0f, -13.0f)
          lineToRelative(-2.0f, -14.0f)
          lineToRelative(0.0f, -8.0f)
          lineToRelative(2.0f, -10.0f)
          lineToRelative(0.0f, -10.0f)
          lineToRelative(1.0f, -11.0f)
          quadToRelative(0.0f, -13.0f, -1.5f, -22.5f)
          quadToRelative(-1.5f, -9.5f, -9.5f, -22.5f)
          quadToRelative(-3.0f, -10.0f, -11.0f, -15.0f)
          lineToRelative(-14.0f, -14.0f)
          lineToRelative(-1.0f, -1.0f)
          quadToRelative(-12.0f, -9.0f, -21.0f, -21.0f)
          quadToRelative(-9.0f, -12.0f, -9.0f, -33.0f)
          quadToRelative(0.0f, -11.0f, 2.0f, -16.0f)
          lineToRelative(6.0f, -13.0f)
          lineToRelative(4.0f, -7.0f)
          lineToRelative(4.0f, -8.0f)
          lineToRelative(12.0f, -26.0f)
          quadToRelative(6.0f, -15.0f, 6.0f, -42.0f)
          quadToRelative(0.0f, -25.0f, -14.0f, -38.0f)
          quadToRelative(-4.0f, -3.0f, -13.5f, -8.0f)
          quadToRelative(-9.5f, -5.0f, -23.5f, -5.0f)
          quadToRelative(-25.0f, -0.0f, -39.5f, 13.0f)
          quadTo(448.0f, 417.0f, 448.0f, 442.0f)
          quadTo(448.0f, 468.0f, 452.5f, 482.5f)
          quadTo(457.0f, 497.0f, 463.0f, 506.0f)
          lineToRelative(2.0f, 4.0f)
          lineToRelative(4.0f, 8.0f)
          lineToRelative(5.0f, 7.0f)
          lineToRelative(6.0f, 13.0f)
          lineToRelative(2.0f, 16.0f)
          quadToRelative(0.0f, 21.0f, -9.0f, 33.0f)
          lineToRelative(-20.0f, 21.0f)
          lineToRelative(-2.0f, 2.0f)
          lineToRelative(-14.0f, 13.0f)
          lineToRelative(-10.0f, 15.0f)
          lineToRelative(-10.0f, 26.0f)
          lineToRelative(-2.0f, 22.0f)
          lineToRelative(0.0f, 10.0f)
          lineToRelative(2.0f, 10.0f)
          lineToRelative(0.0f, 9.0f)
          lineToRelative(1.0f, 8.0f)
          lineToRelative(-3.0f, 14.0f)
          quadToRelative(-2.0f, 7.0f, -7.0f, 12.0f)
          lineTo(389.0f, 766.0f)
          lineTo(364.0f, 785.0f)
          quadTo(346.0f, 799.0f, 327.0f, 821.0f)
          quadTo(311.0f, 842.0f, 311.0f, 869.0f)
          lineToRelative(379.0f, -0.0f)
          close()
        }

        path(
          fill = SolidColor(fill),
          stroke = null,
          strokeLineWidth = 0.0f,
          strokeLineCap = Butt,
          strokeLineJoin = Miter,
          strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(313.65f, 860.13f)
          curveToRelative(0.28f, -15.69f, 18.51f, -42.2f, 44.68f, -64.93f)
          curveToRelative(15.9f, -13.81f, 36.12f, -32.0f, 44.94f, -40.41f)
          lineToRelative(16.04f, -15.3f)
          lineToRelative(-0.38f, -37.67f)
          curveToRelative(-0.47f, -46.84f, 5.18f, -60.96f, 38.88f, -97.19f)
          curveToRelative(23.15f, -24.89f, 25.24f, -28.72f, 25.24f, -46.41f)
          curveToRelative(0.0f, -13.83f, -4.4f, -27.93f, -15.58f, -49.9f)
          curveToRelative(-13.39f, -26.31f, -15.59f, -34.71f, -15.7f, -59.73f)
          curveToRelative(-0.12f, -27.52f, 0.62f, -29.79f, 13.52f, -41.31f)
          curveToRelative(10.79f, -9.64f, 17.68f, -12.2f, 32.86f, -12.2f)
          curveToRelative(54.29f, 0.0f, 67.46f, 44.38f, 33.94f, 114.33f)
          curveToRelative(-15.62f, 32.6f, -18.69f, 53.13f, -10.35f, 69.21f)
          curveToRelative(2.64f, 5.09f, 15.83f, 20.84f, 29.3f, 34.99f)
          curveToRelative(29.02f, 30.49f, 35.89f, 49.84f, 31.68f, 89.18f)
          curveToRelative(-3.59f, 33.57f, 1.79f, 44.37f, 35.2f, 70.62f)
          curveToRelative(44.65f, 35.08f, 68.06f, 63.32f, 68.36f, 82.47f)
          lineToRelative(0.15f, 9.53f)
          lineToRelative(-186.44f, 0.0f)
          curveToRelative(-146.38f, 0.0f, -186.42f, -1.14f, -186.35f, -5.3f)
          close()
        }
      }
        .build()
    }
  }
