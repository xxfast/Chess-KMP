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

public val RegularGroup.Wq: ImageVector
  @Composable get() {
    val stroke: Color = MaterialTheme.colorScheme.primary
    val fill: Color = MaterialTheme.colorScheme.surface

    return remember(stroke, fill) {
      Builder(
        name = "Wq", defaultWidth = 1000.0.dp, defaultHeight = 1000.0.dp,
        viewportWidth = 1000.0f, viewportHeight = 1000.0f
      ).apply {
        path(
          fill = SolidColor(stroke), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(196.0f, 940.0f)
          quadToRelative(0.0f, -45.0f, 1.5f, -62.0f)
          quadToRelative(1.5f, -17.0f, 7.5f, -53.0f)
          quadToRelative(6.0f, -36.0f, 56.0f, -75.0f)
          lineToRelative(-91.0f, -289.0f)
          quadToRelative(-29.0f, -0.0f, -48.0f, -21.0f)
          quadToRelative(-19.0f, -21.0f, -19.0f, -49.0f)
          quadToRelative(0.0f, -31.0f, 21.0f, -52.0f)
          quadToRelative(21.0f, -21.0f, 50.0f, -21.0f)
          quadToRelative(30.0f, -0.0f, 51.0f, 21.5f)
          quadToRelative(21.0f, 21.5f, 21.0f, 51.5f)
          lineToRelative(-3.0f, 18.0f)
          quadToRelative(-2.0f, 9.0f, -11.0f, 20.0f)
          lineToRelative(79.0f, 84.0f)
          lineToRelative(30.0f, -153.0f)
          quadToRelative(-25.0f, -11.0f, -39.0f, -31.0f)
          quadToRelative(-14.0f, -20.0f, -14.0f, -45.0f)
          quadToRelative(0.0f, -33.0f, 23.5f, -56.5f)
          quadToRelative(23.5f, -23.5f, 57.5f, -23.5f)
          quadToRelative(32.0f, -0.0f, 57.0f, 23.5f)
          quadToRelative(25.0f, 23.5f, 25.0f, 56.5f)
          quadToRelative(0.0f, 19.0f, -9.5f, 36.5f)
          quadTo(432.0f, 338.0f, 417.0f, 350.0f)
          lineToRelative(81.0f, 151.0f)
          lineToRelative(82.0f, -151.0f)
          quadToRelative(-10.0f, -7.0f, -17.5f, -17.5f)
          quadTo(555.0f, 322.0f, 550.0f, 308.0f)
          lineToRelative(-3.0f, -13.0f)
          lineToRelative(-1.0f, -11.0f)
          quadToRelative(0.0f, -32.0f, 24.0f, -56.0f)
          quadToRelative(24.0f, -24.0f, 57.0f, -24.0f)
          quadToRelative(32.0f, -0.0f, 57.0f, 23.5f)
          quadTo(709.0f, 251.0f, 709.0f, 284.0f)
          quadTo(709.0f, 308.0f, 694.5f, 329.0f)
          quadTo(680.0f, 350.0f, 656.0f, 360.0f)
          lineToRelative(28.0f, 154.0f)
          lineToRelative(80.0f, -85.0f)
          lineToRelative(-7.0f, -18.0f)
          lineToRelative(-3.0f, -20.0f)
          quadToRelative(0.0f, -31.0f, 21.0f, -52.0f)
          quadToRelative(21.0f, -21.0f, 50.0f, -21.0f)
          quadToRelative(30.0f, -0.0f, 51.0f, 21.5f)
          quadTo(897.0f, 361.0f, 897.0f, 391.0f)
          quadTo(897.0f, 419.0f, 878.5f, 438.5f)
          quadTo(860.0f, 458.0f, 831.0f, 461.0f)
          lineTo(738.0f, 748.0f)
          quadToRelative(49.0f, 37.0f, 58.0f, 85.0f)
          quadToRelative(9.0f, 48.0f, 9.0f, 107.0f)
          lineTo(196.0f, 940.0f)
          close()
          moveTo(731.0f, 869.0f)
          quadToRelative(0.0f, -33.0f, -26.5f, -47.5f)
          quadTo(678.0f, 807.0f, 632.0f, 794.0f)
          lineToRelative(-23.0f, -5.0f)
          lineToRelative(-22.0f, -4.0f)
          lineToRelative(-41.0f, -2.0f)
          lineToRelative(-34.0f, -0.0f)
          lineToRelative(-8.0f, -0.0f)
          lineToRelative(-6.0f, -0.0f)
          lineToRelative(-4.0f, -0.0f)
          lineToRelative(-39.0f, 1.0f)
          lineToRelative(-33.0f, -0.0f)
          quadToRelative(-16.0f, 3.0f, -23.0f, 4.0f)
          lineToRelative(-22.0f, 3.0f)
          lineToRelative(-20.0f, 4.0f)
          quadTo(323.0f, 802.0f, 296.5f, 818.0f)
          quadTo(270.0f, 834.0f, 270.0f, 869.0f)
          lineTo(731.0f, 869.0f)
          close()
          moveTo(651.0f, 617.0f)
          lineTo(615.0f, 404.0f)
          lineTo(498.0f, 613.0f)
          lineTo(383.0f, 404.0f)
          lineTo(345.0f, 619.0f)
          lineTo(242.0f, 514.0f)
          lineToRelative(-2.0f, 3.0f)
          lineToRelative(81.0f, 210.0f)
          lineToRelative(51.0f, -8.0f)
          lineToRelative(49.0f, -5.0f)
          lineToRelative(33.0f, -1.0f)
          lineToRelative(34.0f, -1.0f)
          lineToRelative(78.0f, 3.0f)
          lineToRelative(85.0f, 9.0f)
          lineToRelative(15.0f, 3.0f)
          quadToRelative(10.0f, -0.0f, 16.0f, 2.0f)
          lineToRelative(75.0f, -213.0f)
          lineToRelative(-2.0f, -2.0f)
          close()
          moveTo(157.0f, 407.0f)
          quadToRelative(6.0f, 6.0f, 17.0f, 7.0f)
          quadToRelative(11.0f, -0.0f, 17.0f, -7.0f)
          quadToRelative(6.0f, -7.0f, 8.0f, -18.0f)
          quadToRelative(0.0f, -9.0f, -6.0f, -15.5f)
          quadToRelative(-6.0f, -6.5f, -19.0f, -8.5f)
          quadToRelative(-9.0f, -0.0f, -16.0f, 6.5f)
          quadToRelative(-7.0f, 6.5f, -8.0f, 17.5f)
          quadToRelative(0.0f, 10.0f, 7.0f, 18.0f)
          close()
          moveTo(808.0f, 407.0f)
          quadToRelative(6.0f, 6.0f, 17.0f, 7.0f)
          quadToRelative(9.0f, -0.0f, 16.0f, -6.5f)
          quadToRelative(7.0f, -6.5f, 9.0f, -18.5f)
          quadToRelative(0.0f, -9.0f, -8.0f, -16.0f)
          quadToRelative(-5.0f, -7.0f, -17.0f, -8.0f)
          quadToRelative(-9.0f, -0.0f, -15.5f, 6.5f)
          quadTo(803.0f, 378.0f, 801.0f, 389.0f)
          quadToRelative(0.0f, 10.0f, 7.0f, 18.0f)
          close()
          moveTo(349.0f, 306.0f)
          quadToRelative(8.0f, 6.0f, 20.0f, 8.0f)
          quadToRelative(12.0f, -0.0f, 20.5f, -8.5f)
          quadToRelative(8.5f, -8.5f, 8.5f, -20.5f)
          quadToRelative(0.0f, -11.0f, -7.5f, -19.0f)
          quadToRelative(-7.5f, -8.0f, -21.5f, -9.0f)
          quadToRelative(-11.0f, -0.0f, -18.5f, 7.0f)
          quadToRelative(-7.5f, 7.0f, -9.5f, 21.0f)
          quadToRelative(0.0f, 13.0f, 8.0f, 21.0f)
          close()
          moveTo(607.0f, 306.0f)
          quadToRelative(8.0f, 6.0f, 20.0f, 8.0f)
          quadToRelative(13.0f, -0.0f, 21.0f, -8.0f)
          quadToRelative(6.0f, -8.0f, 8.0f, -21.0f)
          quadToRelative(0.0f, -12.0f, -7.0f, -19.0f)
          quadToRelative(-7.0f, -7.0f, -22.0f, -9.0f)
          quadToRelative(-11.0f, -0.0f, -18.5f, 7.0f)
          quadToRelative(-7.5f, 7.0f, -9.5f, 21.0f)
          quadToRelative(0.0f, 13.0f, 8.0f, 21.0f)
          close()
        }
        path(
          fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(648.31f, 722.05f)
          curveToRelative(-10.49f, -1.83f, -54.75f, -5.74f, -98.35f, -8.68f)
          curveToRelative(-65.25f, -4.4f, -89.62f, -4.34f, -137.71f, 0.34f)
          curveToRelative(-32.14f, 3.13f, -65.83f, 5.85f, -74.88f, 6.03f)
          lineToRelative(-16.46f, 0.34f)
          lineToRelative(-37.5f, -97.18f)
          curveToRelative(-20.62f, -53.45f, -36.82f, -97.86f, -35.98f, -98.69f)
          curveToRelative(0.83f, -0.83f, 22.72f, 20.82f, 48.64f, 48.11f)
          curveToRelative(25.92f, 27.3f, 48.05f, 48.7f, 49.19f, 47.57f)
          curveToRelative(1.13f, -1.13f, 10.33f, -48.54f, 20.43f, -105.34f)
          lineToRelative(18.36f, -103.28f)
          lineToRelative(38.32f, 69.66f)
          curveToRelative(21.08f, 38.31f, 46.39f, 84.43f, 56.25f, 102.5f)
          curveToRelative(9.86f, 18.06f, 18.52f, 32.84f, 19.26f, 32.84f)
          curveToRelative(0.73f, 0.0f, 26.78f, -45.6f, 57.88f, -101.32f)
          curveToRelative(31.1f, -55.73f, 57.12f, -100.76f, 57.82f, -100.07f)
          curveToRelative(1.34f, 1.33f, 34.58f, 196.29f, 34.68f, 203.44f)
          curveToRelative(0.03f, 2.29f, 22.94f, -18.65f, 50.91f, -46.54f)
          curveTo(727.12f, 543.89f, 750.0f, 522.82f, 750.0f, 524.96f)
          curveToRelative(0.0f, 2.14f, -15.7f, 48.35f, -34.89f, 102.69f)
          curveToRelative(-25.46f, 72.08f, -36.63f, 98.65f, -41.31f, 98.27f)
          curveToRelative(-3.53f, -0.29f, -15.0f, -2.03f, -25.49f, -3.86f)
          close()
        }
        path(
          fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(271.19f, 864.24f)
          curveToRelative(0.0f, -1.12f, 2.97f, -9.46f, 6.6f, -18.53f)
          curveToRelative(4.96f, -12.41f, 11.76f, -19.3f, 27.4f, -27.81f)
          curveToRelative(47.89f, -26.07f, 99.29f, -33.55f, 214.08f, -31.19f)
          curveToRelative(83.06f, 1.71f, 91.11f, 2.59f, 124.81f, 13.64f)
          curveToRelative(59.62f, 19.55f, 76.93f, 30.9f, 82.76f, 54.27f)
          lineToRelative(2.91f, 11.65f)
          lineToRelative(-229.27f, 0.0f)
          curveToRelative(-126.1f, 0.0f, -229.27f, -0.91f, -229.27f, -2.03f)
          close()
        }
        path(
          fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(161.96f, 406.29f)
          curveToRelative(-12.75f, -8.93f, -12.18f, -25.3f, 1.18f, -34.05f)
          curveToRelative(9.81f, -6.43f, 11.37f, -6.43f, 21.19f, 0.0f)
          curveToRelative(13.36f, 8.75f, 13.92f, 25.12f, 1.18f, 34.05f)
          curveToRelative(-5.18f, 3.63f, -10.48f, 6.6f, -11.77f, 6.6f)
          curveToRelative(-1.29f, 0.0f, -6.59f, -2.97f, -11.77f, -6.6f)
          close()
        }
        path(
          fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(351.69f, 302.71f)
          curveToRelative(-10.18f, -10.18f, -10.76f, -20.28f, -1.88f, -32.96f)
          curveToRelative(8.14f, -11.63f, 27.44f, -12.49f, 37.24f, -1.67f)
          curveToRelative(22.3f, 24.64f, -11.88f, 58.1f, -35.36f, 34.62f)
          close()
        }
        path(
          fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(610.17f, 302.71f)
          curveToRelative(-10.18f, -10.18f, -10.76f, -20.28f, -1.88f, -32.96f)
          curveToRelative(8.14f, -11.63f, 27.44f, -12.49f, 37.24f, -1.67f)
          curveToRelative(21.97f, 24.28f, -12.22f, 57.76f, -35.36f, 34.62f)
          close()
        }
        path(
          fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(814.5f, 406.29f)
          curveToRelative(-11.42f, -8.0f, -12.2f, -23.47f, -1.67f, -33.0f)
          curveToRelative(10.13f, -9.17f, 15.84f, -8.85f, 26.15f, 1.46f)
          curveToRelative(10.72f, 10.72f, 10.72f, 18.94f, 0.0f, 29.66f)
          curveToRelative(-10.2f, 10.2f, -12.36f, 10.37f, -24.48f, 1.88f)
          close()
        }
      }
        .build()
    }
  }
