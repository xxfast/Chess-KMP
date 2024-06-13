package io.github.xxfast.chess.resources.pieces.pieces.regular

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import io.github.xxfast.chess.resources.pieces.pieces.RegularGroup

public val RegularGroup.Wn: ImageVector
  @Composable get() {
    val stroke: Color = MaterialTheme.colorScheme.primary
    val fill: Color = MaterialTheme.colorScheme.surface

    return remember(stroke, fill) {
      Builder(
        name = "Wn", defaultWidth = 1000.0.dp, defaultHeight = 1000.0.dp,
        viewportWidth = 1000.0f, viewportHeight = 1000.0f
      ).apply {
        path(
          fill = SolidColor(stroke), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(227.0f, 940.0f)
          lineToRelative(0.0f, -18.0f)
          lineToRelative(1.0f, -18.0f)
          quadToRelative(0.0f, -24.0f, 6.5f, -47.5f)
          quadToRelative(6.5f, -23.5f, 19.5f, -48.5f)
          quadToRelative(21.0f, -45.0f, 83.0f, -69.0f)
          quadToRelative(0.0f, -30.0f, 26.0f, -53.0f)
          lineToRelative(58.0f, -42.0f)
          lineToRelative(6.0f, -4.0f)
          lineToRelative(6.0f, -4.0f)
          lineToRelative(50.0f, -37.0f)
          quadToRelative(22.0f, -19.0f, 22.0f, -44.0f)
          lineToRelative(-3.0f, -15.0f)
          quadToRelative(-3.0f, -6.0f, -16.0f, -7.0f)
          lineToRelative(-9.0f, 3.0f)
          lineToRelative(-7.0f, 7.0f)
          lineToRelative(-8.0f, 10.0f)
          lineToRelative(-7.0f, 10.0f)
          lineToRelative(-12.0f, 14.0f)
          lineToRelative(-15.0f, 11.0f)
          lineToRelative(-18.0f, 8.0f)
          quadToRelative(-2.0f, 1.0f, -19.0f, 6.0f)
          lineTo(359.0f, 612.0f)
          quadTo(343.0f, 616.0f, 332.5f, 622.5f)
          quadTo(322.0f, 629.0f, 320.5f, 639.5f)
          quadTo(319.0f, 650.0f, 318.0f, 651.0f)
          lineToRelative(-3.0f, 6.0f)
          quadToRelative(-8.0f, 8.0f, -28.0f, 19.0f)
          quadToRelative(-19.0f, 8.0f, -40.0f, 8.0f)
          quadToRelative(-39.0f, -0.0f, -62.0f, -29.0f)
          quadToRelative(-23.0f, -29.0f, -26.0f, -64.0f)
          lineToRelative(0.0f, -6.0f)
          quadToRelative(0.0f, -38.0f, 18.0f, -70.0f)
          quadToRelative(10.0f, -18.0f, 19.0f, -31.5f)
          quadToRelative(9.0f, -13.5f, 22.0f, -28.5f)
          lineToRelative(17.0f, -21.0f)
          lineToRelative(16.0f, -22.0f)
          quadToRelative(8.0f, -11.0f, 10.0f, -15.0f)
          quadToRelative(3.0f, -6.0f, 7.5f, -16.0f)
          quadToRelative(4.5f, -10.0f, 6.5f, -17.5f)
          quadToRelative(2.0f, -7.5f, 2.0f, -18.5f)
          quadToRelative(0.0f, -16.0f, 11.0f, -27.0f)
          lineToRelative(28.0f, -25.0f)
          lineToRelative(4.0f, -3.0f)
          lineToRelative(5.0f, -3.0f)
          lineToRelative(31.0f, -27.0f)
          quadToRelative(16.0f, -16.0f, 16.0f, -33.0f)
          lineToRelative(2.0f, -14.0f)
          quadToRelative(0.0f, -11.0f, 2.5f, -22.0f)
          quadToRelative(2.5f, -11.0f, 9.0f, -22.0f)
          quadToRelative(6.5f, -11.0f, 20.5f, -14.0f)
          quadToRelative(13.0f, 7.0f, 27.0f, 23.0f)
          lineToRelative(29.0f, 33.0f)
          quadTo(477.0f, 232.0f, 494.5f, 248.5f)
          quadTo(512.0f, 265.0f, 531.0f, 270.0f)
          quadToRelative(3.0f, 1.0f, 16.5f, 4.5f)
          quadTo(561.0f, 278.0f, 579.0f, 284.0f)
          quadTo(618.0f, 295.0f, 663.5f, 326.5f)
          quadTo(709.0f, 358.0f, 751.0f, 420.5f)
          quadTo(793.0f, 483.0f, 793.0f, 588.0f)
          quadToRelative(0.0f, 21.0f, -1.0f, 39.0f)
          quadToRelative(-1.0f, 18.0f, -4.0f, 34.0f)
          lineToRelative(-12.0f, 58.0f)
          lineToRelative(-4.0f, 11.0f)
          lineToRelative(-3.0f, 11.0f)
          quadToRelative(54.0f, 35.0f, 63.0f, 81.0f)
          quadToRelative(9.0f, 46.0f, 9.0f, 101.0f)
          lineTo(841.0f, 932.0f)
          lineTo(841.0f, 940.0f)
          lineTo(227.0f, 940.0f)
          close()
          moveTo(767.0f, 869.0f)
          quadToRelative(0.0f, -33.0f, -27.0f, -48.0f)
          quadToRelative(-13.0f, -8.0f, -27.0f, -13.0f)
          quadToRelative(-14.0f, -5.0f, -40.0f, -13.0f)
          lineToRelative(-3.0f, -1.0f)
          lineToRelative(-21.0f, -5.0f)
          lineToRelative(-18.0f, -3.0f)
          lineToRelative(-46.0f, -3.0f)
          lineToRelative(-39.0f, -0.0f)
          lineToRelative(-9.0f, -0.0f)
          lineToRelative(-8.0f, -0.0f)
          lineToRelative(-4.0f, -0.0f)
          lineToRelative(-4.0f, -0.0f)
          lineToRelative(-39.0f, 1.0f)
          lineToRelative(-52.0f, 3.0f)
          lineToRelative(-22.0f, 3.0f)
          lineToRelative(-20.0f, 4.0f)
          quadTo(353.0f, 803.0f, 327.0f, 818.5f)
          quadTo(301.0f, 834.0f, 301.0f, 869.0f)
          lineToRelative(466.0f, -0.0f)
          close()
          moveTo(674.0f, 436.0f)
          quadToRelative(-48.0f, -63.0f, -106.0f, -93.0f)
          quadToRelative(-18.0f, -10.0f, -38.0f, -16.0f)
          quadToRelative(-20.0f, -6.0f, -39.0f, -6.0f)
          quadToRelative(-6.0f, -0.0f, -15.0f, -9.0f)
          lineToRelative(-17.0f, -20.0f)
          lineToRelative(-2.0f, -2.0f)
          lineToRelative(-19.0f, -24.0f)
          quadToRelative(-8.0f, -8.0f, -15.0f, -10.0f)
          lineToRelative(-4.0f, 2.0f)
          quadToRelative(-3.0f, 21.0f, -14.0f, 36.0f)
          quadToRelative(-11.0f, 15.0f, -24.0f, 26.0f)
          lineToRelative(-26.0f, 20.0f)
          quadToRelative(-10.0f, 7.0f, -13.0f, 16.0f)
          quadToRelative(-10.0f, 35.0f, -22.0f, 60.0f)
          lineTo(296.0f, 461.0f)
          quadTo(279.0f, 487.0f, 263.5f, 505.5f)
          quadTo(248.0f, 524.0f, 240.0f, 539.0f)
          lineToRelative(-8.0f, 16.0f)
          lineToRelative(-2.0f, 15.0f)
          lineToRelative(0.0f, 6.0f)
          lineToRelative(1.0f, 6.0f)
          quadToRelative(2.0f, 13.0f, 8.0f, 22.0f)
          quadToRelative(6.0f, 9.0f, 18.0f, 9.0f)
          lineToRelative(9.0f, -1.0f)
          lineToRelative(7.0f, -4.0f)
          lineToRelative(8.0f, -8.0f)
          lineToRelative(13.0f, -14.0f)
          lineToRelative(2.0f, -2.0f)
          lineToRelative(4.0f, -3.0f)
          lineToRelative(17.0f, -10.0f)
          lineToRelative(22.0f, -10.0f)
          lineToRelative(32.0f, -12.0f)
          lineToRelative(18.0f, -5.0f)
          quadToRelative(7.0f, -1.0f, 9.0f, -2.0f)
          lineToRelative(8.0f, -8.0f)
          lineToRelative(11.0f, -14.0f)
          lineToRelative(13.0f, -17.0f)
          lineToRelative(24.0f, -28.0f)
          quadToRelative(15.0f, -13.0f, 32.0f, -13.0f)
          lineToRelative(6.0f, -0.0f)
          quadToRelative(24.0f, -0.0f, 44.0f, 18.0f)
          quadToRelative(20.0f, 18.0f, 32.0f, 41.0f)
          lineToRelative(6.0f, 16.0f)
          lineToRelative(2.0f, 15.0f)
          quadTo(576.0f, 600.0f, 553.5f, 624.5f)
          quadTo(531.0f, 649.0f, 503.0f, 667.0f)
          lineToRelative(-25.0f, 13.0f)
          quadToRelative(-14.0f, 5.0f, -21.0f, 11.0f)
          lineToRelative(-20.0f, 13.0f)
          quadToRelative(-5.0f, 5.0f, -7.0f, 16.0f)
          lineToRelative(44.0f, -5.0f)
          quadToRelative(27.0f, -3.0f, 76.0f, -3.0f)
          lineToRelative(82.0f, 3.0f)
          quadToRelative(12.0f, -0.0f, 23.5f, 0.5f)
          quadToRelative(11.5f, 0.5f, 42.5f, 4.5f)
          quadToRelative(12.0f, -19.0f, 20.0f, -61.0f)
          quadToRelative(2.0f, -13.0f, 3.0f, -40.5f)
          quadToRelative(1.0f, -27.5f, 1.0f, -43.5f)
          quadToRelative(0.0f, -74.0f, -48.0f, -139.0f)
          close()
        }
        path(
          fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(434.54f, 711.72f)
          curveToRelative(1.31f, -3.41f, 19.74f, -15.51f, 40.96f, -26.88f)
          curveToRelative(50.15f, -26.88f, 89.64f, -63.88f, 96.64f, -90.53f)
          curveToRelative(8.54f, -32.49f, 3.89f, -66.88f, -12.19f, -90.26f)
          curveToRelative(-19.31f, -28.06f, -42.44f, -42.6f, -68.4f, -42.98f)
          curveToRelative(-25.46f, -0.38f, -35.87f, 6.8f, -69.11f, 47.66f)
          curveToRelative(-20.05f, 24.64f, -27.88f, 31.09f, -42.37f, 34.94f)
          curveToRelative(-31.49f, 8.35f, -85.15f, 36.27f, -100.18f, 52.12f)
          curveToRelative(-8.03f, 8.47f, -17.9f, 15.4f, -21.94f, 15.4f)
          curveToRelative(-11.12f, 0.0f, -24.9f, -20.37f, -24.9f, -36.8f)
          curveToRelative(0.0f, -18.22f, 6.91f, -31.52f, 40.47f, -77.9f)
          curveToRelative(29.25f, -40.43f, 51.51f, -81.94f, 63.43f, -118.29f)
          curveToRelative(4.42f, -13.49f, 13.12f, -28.4f, 20.72f, -35.52f)
          curveToRelative(44.19f, -41.41f, 54.06f, -52.77f, 58.41f, -67.3f)
          curveToRelative(2.62f, -8.74f, 6.13f, -15.89f, 7.81f, -15.89f)
          curveToRelative(1.68f, 0.0f, 15.6f, 14.03f, 30.94f, 31.17f)
          curveToRelative(26.6f, 29.73f, 28.94f, 31.29f, 50.31f, 33.78f)
          curveToRelative(77.41f, 9.02f, 174.46f, 98.55f, 205.19f, 189.29f)
          curveToRelative(12.41f, 36.64f, 11.09f, 131.26f, -2.42f, 173.03f)
          lineToRelative(-10.05f, 31.09f)
          lineToRelative(-29.87f, -3.0f)
          curveToRelative(-40.07f, -4.02f, -185.72f, -4.1f, -213.56f, -0.12f)
          curveToRelative(-18.65f, 2.67f, -21.88f, 2.18f, -19.89f, -3.01f)
          lineToRelative(0.0f, 0.0f)
          close()
        }
        path(
          fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(306.74f, 851.86f)
          curveToRelative(3.6f, -18.01f, 15.96f, -30.46f, 40.85f, -41.17f)
          curveToRelative(45.64f, -19.64f, 72.11f, -22.99f, 184.19f, -23.33f)
          curveToRelative(99.55f, -0.3f, 107.97f, 0.28f, 139.83f, 9.7f)
          curveToRelative(58.57f, 17.33f, 91.1f, 38.92f, 91.1f, 60.46f)
          curveToRelative(0.0f, 7.62f, -8.35f, 7.9f, -229.34f, 7.9f)
          lineToRelative(-229.34f, 0.0f)
          lineToRelative(2.71f, -13.57f)
          close()
        }
      }
        .build()
    }
  }

