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

public val RegularGroup.Wk: ImageVector
  @Composable get() {
    val stroke: Color = MaterialTheme.colorScheme.primary
    val fill: Color = MaterialTheme.colorScheme.surface

    return remember(stroke, fill) {
      Builder(
        name = "Wk", defaultWidth = 1000.0.dp, defaultHeight = 1000.0.dp,
        viewportWidth = 1000.0f, viewportHeight = 1000.0f
      ).apply {
        path(
          fill = SolidColor(stroke), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(195.0f, 940.0f)
          quadToRelative(0.0f, -45.0f, 1.5f, -62.0f)
          quadToRelative(1.5f, -17.0f, 6.5f, -43.0f)
          quadToRelative(9.0f, -46.0f, 58.0f, -85.0f)
          quadToRelative(0.0f, -14.0f, -1.0f, -22.5f)
          quadToRelative(-1.0f, -8.5f, -6.0f, -18.5f)
          quadToRelative(-8.0f, -19.0f, -22.0f, -36.0f)
          lineToRelative(-18.0f, -20.0f)
          lineToRelative(-19.0f, -23.0f)
          quadToRelative(-21.0f, -25.0f, -43.0f, -63.0f)
          quadToRelative(-10.0f, -19.0f, -16.5f, -42.0f)
          quadToRelative(-6.5f, -23.0f, -6.5f, -49.0f)
          lineToRelative(0.0f, -13.0f)
          lineToRelative(1.0f, -13.0f)
          quadToRelative(8.0f, -57.0f, 47.0f, -103.0f)
          quadToRelative(39.0f, -46.0f, 99.0f, -46.0f)
          quadToRelative(60.0f, -0.0f, 96.0f, 26.0f)
          quadToRelative(37.0f, 24.0f, 62.0f, 56.0f)
          quadToRelative(21.0f, 27.0f, 37.0f, 57.0f)
          quadToRelative(13.0f, 24.0f, 25.0f, 25.0f)
          quadToRelative(7.0f, -0.0f, 19.5f, -25.5f)
          quadToRelative(12.5f, -25.5f, 36.5f, -56.5f)
          quadToRelative(24.0f, -31.0f, 62.0f, -56.5f)
          quadToRelative(38.0f, -25.5f, 100.0f, -25.5f)
          quadToRelative(81.0f, -0.0f, 119.5f, 53.5f)
          quadTo(872.0f, 408.0f, 872.0f, 484.0f)
          quadTo(872.0f, 526.0f, 852.0f, 560.0f)
          quadTo(841.0f, 579.0f, 832.0f, 592.5f)
          quadTo(823.0f, 606.0f, 808.0f, 624.0f)
          lineToRelative(-30.0f, 39.0f)
          lineToRelative(-23.0f, 36.0f)
          lineToRelative(-8.0f, 21.0f)
          lineToRelative(-3.0f, 21.0f)
          lineToRelative(0.0f, 5.0f)
          lineToRelative(1.0f, 6.0f)
          quadTo(794.0f, 786.0f, 802.5f, 835.0f)
          quadTo(811.0f, 884.0f, 811.0f, 940.0f)
          lineTo(195.0f, 940.0f)
          close()
          moveTo(737.0f, 869.0f)
          quadToRelative(0.0f, -37.0f, -26.5f, -52.0f)
          quadToRelative(-26.5f, -15.0f, -72.5f, -24.0f)
          lineToRelative(-28.0f, -4.0f)
          lineToRelative(-44.0f, -3.0f)
          lineToRelative(-15.0f, -0.0f)
          quadToRelative(-9.0f, -0.0f, -25.0f, -2.0f)
          lineToRelative(-28.0f, -1.0f)
          lineToRelative(-27.0f, 1.0f)
          lineToRelative(-45.0f, 3.0f)
          quadToRelative(-20.0f, -0.0f, -32.0f, 2.0f)
          lineToRelative(-26.0f, 3.0f)
          lineToRelative(-8.0f, 1.0f)
          lineToRelative(-5.0f, 1.0f)
          quadTo(322.0f, 798.0f, 295.5f, 814.0f)
          quadTo(269.0f, 830.0f, 269.0f, 869.0f)
          lineToRelative(468.0f, -0.0f)
          close()
          moveTo(477.0f, 540.0f)
          lineTo(460.0f, 524.0f)
          lineTo(438.0f, 495.0f)
          lineTo(414.0f, 459.0f)
          quadToRelative(-24.0f, -35.0f, -56.0f, -60.0f)
          quadToRelative(-32.0f, -27.0f, -83.0f, -27.0f)
          quadToRelative(-25.0f, -0.0f, -40.0f, 14.0f)
          quadToRelative(-15.0f, 14.0f, -25.0f, 34.0f)
          lineToRelative(-8.0f, 26.0f)
          lineToRelative(-2.0f, 18.0f)
          quadToRelative(0.0f, 46.0f, 19.0f, 78.5f)
          quadToRelative(19.0f, 32.5f, 46.0f, 66.5f)
          lineToRelative(22.0f, 28.0f)
          lineToRelative(21.0f, 28.0f)
          lineToRelative(15.0f, 30.0f)
          quadToRelative(6.0f, 14.0f, 6.0f, 30.0f)
          quadToRelative(26.0f, -5.0f, 42.5f, -7.5f)
          quadToRelative(16.5f, -2.5f, 36.5f, -2.5f)
          lineToRelative(83.0f, -3.0f)
          lineToRelative(43.0f, 1.0f)
          lineToRelative(45.0f, 3.0f)
          quadToRelative(26.0f, -0.0f, 49.0f, 4.0f)
          quadToRelative(13.0f, -0.0f, 21.0f, 1.0f)
          quadToRelative(8.0f, 1.0f, 26.0f, 4.0f)
          quadToRelative(0.0f, -25.0f, 12.0f, -47.5f)
          quadToRelative(12.0f, -22.5f, 27.0f, -41.5f)
          lineToRelative(12.0f, -15.0f)
          lineToRelative(12.0f, -15.0f)
          quadToRelative(24.0f, -29.0f, 43.5f, -62.5f)
          quadToRelative(19.5f, -33.5f, 19.5f, -78.5f)
          quadToRelative(0.0f, -49.0f, -28.0f, -71.0f)
          quadToRelative(-28.0f, -22.0f, -73.0f, -22.0f)
          quadToRelative(-49.0f, -0.0f, -80.0f, 27.0f)
          quadToRelative(-31.0f, 27.0f, -52.0f, 60.0f)
          lineToRelative(-21.0f, 34.0f)
          lineToRelative(-18.0f, 28.0f)
          quadToRelative(-6.0f, 11.0f, -15.0f, 17.5f)
          quadToRelative(-9.0f, 6.5f, -18.0f, 6.5f)
          quadToRelative(-10.0f, -0.0f, -19.0f, -5.0f)
          close()
          moveTo(550.0f, 146.0f)
          quadToRelative(21.0f, 18.0f, 21.0f, 47.0f)
          quadToRelative(0.0f, 11.0f, -8.0f, 39.5f)
          quadTo(555.0f, 261.0f, 541.0f, 291.0f)
          lineToRelative(-5.0f, 14.0f)
          lineToRelative(-6.0f, 14.0f)
          lineToRelative(-19.0f, 43.0f)
          lineToRelative(-15.0f, 28.0f)
          quadToRelative(-7.0f, -9.0f, -15.0f, -26.0f)
          lineToRelative(-17.0f, -41.0f)
          lineToRelative(-7.0f, -16.0f)
          lineToRelative(-6.0f, -17.0f)
          lineToRelative(-19.0f, -57.0f)
          quadToRelative(-1.0f, -5.0f, -4.0f, -20.5f)
          quadToRelative(-3.0f, -15.5f, -4.0f, -19.5f)
          quadToRelative(0.0f, -26.0f, 21.0f, -47.0f)
          quadToRelative(22.0f, -19.0f, 55.0f, -19.0f)
          quadToRelative(30.0f, -0.0f, 50.0f, 19.0f)
          close()
          moveTo(479.0f, 191.0f)
          lineTo(475.0f, 212.0f)
          quadToRelative(0.0f, 12.0f, 6.0f, 33.0f)
          lineToRelative(14.0f, 46.0f)
          lineToRelative(15.0f, -46.0f)
          quadToRelative(6.0f, -20.0f, 6.0f, -33.0f)
          quadToRelative(0.0f, -16.0f, -5.0f, -21.0f)
          quadToRelative(-3.0f, -6.0f, -15.0f, -6.0f)
          quadToRelative(-11.0f, -0.0f, -17.0f, 6.0f)
          close()
        }
        path(
          fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(330.47f, 715.28f)
          curveToRelative(-0.08f, -14.75f, -21.1f, -53.25f, -47.98f, -87.85f)
          curveToRelative(-61.92f, -79.73f, -78.71f, -112.63f, -78.96f, -154.74f)
          curveToRelative(-0.2f, -32.75f, 7.47f, -53.81f, 27.77f, -76.2f)
          lineToRelative(17.8f, -19.63f)
          lineToRelative(33.29f, 0.29f)
          curveToRelative(26.09f, 0.23f, 37.38f, 2.41f, 52.17f, 10.06f)
          curveToRelative(25.84f, 13.37f, 61.18f, 49.98f, 92.32f, 95.62f)
          curveToRelative(34.01f, 49.85f, 46.97f, 62.09f, 66.26f, 62.64f)
          curveToRelative(19.47f, 0.55f, 30.91f, -10.14f, 57.97f, -54.17f)
          curveToRelative(56.49f, -91.94f, 95.9f, -120.48f, 159.43f, -115.43f)
          curveToRelative(65.56f, 5.21f, 94.58f, 44.15f, 85.21f, 114.36f)
          curveToRelative(-4.35f, 32.58f, -17.36f, 56.91f, -62.23f, 116.4f)
          curveToRelative(-42.85f, 56.81f, -54.6f, 76.95f, -58.34f, 100.03f)
          curveToRelative(-2.51f, 15.44f, -3.29f, 16.14f, -15.81f, 14.02f)
          curveToRelative(-47.51f, -8.05f, -170.76f, -12.03f, -237.75f, -7.68f)
          curveToRelative(-39.62f, 2.58f, -76.32f, 5.92f, -81.57f, 7.43f)
          curveToRelative(-7.46f, 2.15f, -9.54f, 1.02f, -9.58f, -5.16f)
          lineToRelative(0.0f, 0.0f)
          close()
        }
        path(
          fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(485.39f, 251.1f)
          curveToRelative(-3.98f, -14.73f, -6.61f, -34.41f, -5.85f, -43.73f)
          curveToRelative(1.15f, -13.97f, 3.11f, -17.19f, 11.16f, -18.33f)
          curveToRelative(14.24f, -2.02f, 22.01f, 6.62f, 22.01f, 24.45f)
          curveToRelative(0.0f, 15.34f, -10.77f, 54.03f, -16.96f, 60.91f)
          curveToRelative(-1.72f, 1.91f, -6.38f, -8.58f, -10.36f, -23.31f)
          close()
        }
        path(
          fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
          strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
          pathFillType = NonZero
        ) {
          moveToRelative(272.67f, 853.58f)
          curveToRelative(6.19f, -30.95f, 31.28f, -47.28f, 89.62f, -58.34f)
          curveToRelative(43.53f, -8.25f, 224.05f, -9.13f, 264.83f, -1.3f)
          curveToRelative(68.52f, 13.16f, 105.93f, 35.02f, 105.93f, 61.88f)
          lineToRelative(0.0f, 10.45f)
          lineToRelative(-231.46f, 0.0f)
          lineToRelative(-231.46f, 0.0f)
          lineToRelative(2.54f, -12.69f)
          close()
        }
      }
        .build()
    }
  }
