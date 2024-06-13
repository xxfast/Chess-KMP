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

public val RegularGroup.Wr: ImageVector
  @Composable get() {
    val stroke: Color = MaterialTheme.colorScheme.primary
    val fill: Color = MaterialTheme.colorScheme.surface

    return remember {
      Builder(
        name = "Wr", defaultWidth = 1000.0.dp, defaultHeight = 1000.0.dp,
        viewportWidth = 1000.0f, viewportHeight = 1000.0f
      ).apply {
        path(
          fill = SolidColor(stroke), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(204.0f, 940.0f)
          quadToRelative(0.0f, -66.0f, 8.5f, -111.5f)
          quadTo(221.0f, 783.0f, 271.0f, 740.0f)
          lineToRelative(32.0f, -248.0f)
          lineToRelative(-7.0f, -8.0f)
          lineToRelative(-7.0f, -9.0f)
          lineToRelative(-16.0f, -21.0f)
          lineToRelative(-13.0f, -24.0f)
          quadToRelative(-1.0f, -5.0f, -2.0f, -6.0f)
          lineToRelative(-2.0f, -7.0f)
          quadToRelative(-6.0f, -17.0f, -9.0f, -35.0f)
          lineToRelative(-2.0f, -41.0f)
          lineToRelative(1.0f, -35.0f)
          lineToRelative(5.0f, -39.0f)
          quadToRelative(29.0f, -14.0f, 59.0f, -20.0f)
          lineToRelative(53.0f, -7.0f)
          lineToRelative(21.0f, 46.0f)
          lineToRelative(47.0f, -0.0f)
          lineToRelative(12.0f, -59.0f)
          lineToRelative(30.0f, -3.0f)
          lineToRelative(30.0f, -1.0f)
          lineToRelative(10.0f, -0.0f)
          lineToRelative(10.0f, 1.0f)
          lineToRelative(20.0f, 1.0f)
          lineToRelative(20.0f, 2.0f)
          lineToRelative(9.0f, 59.0f)
          lineToRelative(45.0f, -0.0f)
          lineToRelative(18.0f, -45.0f)
          lineToRelative(10.0f, 1.0f)
          lineToRelative(10.0f, -0.0f)
          lineToRelative(49.0f, 9.0f)
          quadToRelative(25.0f, 5.0f, 45.0f, 16.0f)
          lineToRelative(4.0f, 23.0f)
          lineToRelative(1.0f, 28.0f)
          lineToRelative(-1.0f, 17.0f)
          lineToRelative(0.0f, 18.0f)
          lineToRelative(-4.0f, 31.0f)
          quadToRelative(-1.0f, 9.0f, -1.0f, 18.0f)
          quadToRelative(-3.0f, 7.0f, -4.0f, 10.0f)
          lineToRelative(-2.0f, 4.0f)
          lineToRelative(-8.0f, 19.0f)
          lineToRelative(-8.0f, 15.0f)
          lineToRelative(-13.0f, 20.0f)
          lineToRelative(-16.0f, 22.0f)
          lineToRelative(33.0f, 248.0f)
          quadTo(775.0f, 773.0f, 785.5f, 826.0f)
          quadTo(796.0f, 879.0f, 796.0f, 940.0f)
          lineTo(204.0f, 940.0f)
          close()
          moveTo(722.0f, 869.0f)
          quadToRelative(0.0f, -34.0f, -26.5f, -48.5f)
          quadTo(669.0f, 806.0f, 623.0f, 793.0f)
          lineToRelative(-28.0f, -6.0f)
          lineToRelative(-36.0f, -3.0f)
          lineToRelative(-29.0f, -1.0f)
          lineToRelative(-24.0f, -0.0f)
          lineToRelative(-29.0f, 1.0f)
          lineToRelative(-21.0f, -0.0f)
          quadToRelative(0.0f, -0.0f, -26.0f, 2.0f)
          lineToRelative(-37.0f, 3.0f)
          quadToRelative(-8.0f, 1.0f, -15.0f, 1.0f)
          quadToRelative(-4.0f, 1.0f, -13.0f, 4.0f)
          quadToRelative(-34.0f, 7.0f, -60.5f, 23.0f)
          quadTo(278.0f, 833.0f, 278.0f, 869.0f)
          lineToRelative(444.0f, -0.0f)
          close()
          moveTo(633.0f, 527.0f)
          quadToRelative(-14.0f, -5.0f, -38.0f, -10.0f)
          lineToRelative(-44.0f, -6.0f)
          lineToRelative(-26.0f, -2.0f)
          lineToRelative(-23.0f, -1.0f)
          quadToRelative(-27.0f, -0.0f, -49.0f, 1.0f)
          quadToRelative(-22.0f, 1.0f, -45.5f, 5.0f)
          quadTo(384.0f, 518.0f, 368.0f, 527.0f)
          lineToRelative(-24.0f, 196.0f)
          lineToRelative(75.0f, -8.0f)
          lineToRelative(88.0f, -3.0f)
          lineToRelative(85.0f, 3.0f)
          quadToRelative(20.0f, -0.0f, 31.0f, 1.5f)
          quadToRelative(11.0f, 1.5f, 35.0f, 6.5f)
          close()
          moveTo(566.0f, 366.0f)
          lineTo(545.0f, 309.0f)
          lineTo(522.0f, 305.0f)
          lineTo(500.0f, 304.0f)
          lineTo(480.0f, 306.0f)
          lineTo(460.0f, 309.0f)
          lineTo(437.0f, 366.0f)
          lineToRelative(-61.0f, -0.0f)
          lineToRelative(-23.0f, -55.0f)
          lineToRelative(-4.0f, -1.0f)
          lineToRelative(-4.0f, -0.0f)
          lineToRelative(-10.0f, 2.0f)
          lineToRelative(-10.0f, 3.0f)
          lineToRelative(-5.0f, 2.0f)
          lineToRelative(-5.0f, 2.0f)
          lineToRelative(0.0f, 4.0f)
          quadToRelative(0.0f, 34.0f, 2.0f, 46.5f)
          quadToRelative(2.0f, 12.5f, 10.0f, 34.5f)
          quadToRelative(13.0f, 35.0f, 37.0f, 47.0f)
          lineToRelative(74.0f, -10.0f)
          lineToRelative(62.0f, -4.0f)
          lineToRelative(26.5f, -0.0f)
          quadToRelative(0.0f, -0.0f, 27.5f, 2.0f)
          quadToRelative(28.0f, -0.0f, 49.0f, 5.0f)
          lineToRelative(19.0f, 3.0f)
          lineToRelative(19.0f, 4.0f)
          quadToRelative(22.0f, -12.0f, 31.0f, -40.0f)
          quadToRelative(4.0f, -13.0f, 6.5f, -27.0f)
          quadToRelative(2.5f, -14.0f, 4.5f, -34.0f)
          lineToRelative(1.0f, -16.0f)
          lineToRelative(0.0f, -15.0f)
          lineToRelative(-10.0f, -4.0f)
          lineToRelative(-12.0f, -3.0f)
          lineToRelative(-8.0f, -1.0f)
          lineToRelative(-8.0f, -1.0f)
          lineToRelative(-23.0f, 56.0f)
          lineToRelative(-57.0f, -0.0f)
          close()
        }
        path(
          fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(347.39f, 715.89f)
          curveToRelative(-0.03f, -1.89f, 5.05f, -44.81f, 11.3f, -95.37f)
          curveToRelative(12.96f, -104.87f, 8.54f, -96.94f, 58.68f, -105.13f)
          curveToRelative(67.46f, -11.02f, 213.52f, 1.67f, 214.16f, 18.6f)
          curveToRelative(0.1f, 2.61f, 5.5f, 45.18f, 11.99f, 94.6f)
          lineToRelative(11.81f, 89.85f)
          lineToRelative(-34.24f, -2.99f)
          curveToRelative(-46.29f, -4.04f, -181.46f, -3.78f, -232.33f, 0.44f)
          curveToRelative(-22.72f, 1.89f, -41.34f, 1.89f, -41.38f, 0.0f)
          lineToRelative(0.0f, 0.0f)
          close()
        }
        path(
          fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(351.15f, 436.38f)
          curveToRelative(-20.55f, -22.26f, -33.24f, -57.94f, -33.31f, -93.73f)
          curveToRelative(-0.04f, -20.11f, 1.04f, -22.76f, 10.82f, -26.48f)
          curveToRelative(18.62f, -7.08f, 21.74f, -4.91f, 33.78f, 23.41f)
          lineToRelative(11.71f, 27.54f)
          lineToRelative(32.75f, 0.0f)
          lineToRelative(32.75f, 0.0f)
          lineToRelative(9.57f, -25.58f)
          curveToRelative(5.26f, -14.07f, 13.0f, -27.42f, 17.19f, -29.66f)
          curveToRelative(12.07f, -6.46f, 69.83f, -5.12f, 75.53f, 1.75f)
          curveToRelative(2.66f, 3.2f, 8.31f, 16.07f, 12.56f, 28.6f)
          lineTo(562.22f, 365.0f)
          lineToRelative(31.71f, 1.22f)
          lineToRelative(31.71f, 1.22f)
          lineToRelative(10.56f, -26.65f)
          curveToRelative(9.74f, -24.58f, 11.5f, -26.58f, 22.7f, -25.74f)
          curveToRelative(23.81f, 1.77f, 24.62f, 3.07f, 21.53f, 34.42f)
          curveToRelative(-4.35f, 44.15f, -13.32f, 72.81f, -27.09f, 86.58f)
          curveToRelative(-11.96f, 11.96f, -12.79f, 12.14f, -36.38f, 7.78f)
          curveToRelative(-59.98f, -11.09f, -130.69f, -10.47f, -233.5f, 2.03f)
          curveToRelative(-19.44f, 2.36f, -22.1f, 1.58f, -32.32f, -9.48f)
          lineToRelative(0.0f, 0.0f)
          close()
        }
        path(
          fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(281.61f, 855.47f)
          curveToRelative(4.74f, -19.29f, 14.11f, -30.13f, 35.21f, -40.74f)
          curveToRelative(45.8f, -23.03f, 62.67f, -25.46f, 178.95f, -25.74f)
          lineToRelative(108.05f, -0.26f)
          lineToRelative(42.33f, 14.64f)
          curveToRelative(45.48f, 15.73f, 67.61f, 31.66f, 72.39f, 52.1f)
          lineToRelative(2.73f, 11.65f)
          lineToRelative(-221.26f, 0.0f)
          lineToRelative(-221.26f, 0.0f)
          lineToRelative(2.86f, -11.65f)
          close()
        }
      }
        .build()
    }
  }
