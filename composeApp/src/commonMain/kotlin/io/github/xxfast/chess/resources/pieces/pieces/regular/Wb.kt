package io.github.xxfast.chess.resources.pieces.pieces.regular

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
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

public val RegularGroup.Wb: ImageVector
  @Composable get() {
    val stroke: Color = MaterialTheme.colorScheme.primary
    val fill: Color = MaterialTheme.colorScheme.surface

    return Builder(
      name = "Wb", defaultWidth = 1000.0.dp, defaultHeight = 1000.0.dp,
      viewportWidth = 1000.0f, viewportHeight = 1000.0f
    ).apply {
      path(
        fill = SolidColor(stroke), stroke = null, strokeLineWidth = 0.0f,
        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
        pathFillType = NonZero
      ) {
        moveTo(877.0f, 940.0f)
        lineTo(586.0f, 940.0f)
        quadToRelative(-16.0f, -0.0f, -29.0f, -9.0f)
        quadToRelative(-13.0f, -9.0f, -23.0f, -22.0f)
        lineToRelative(-9.0f, -11.0f)
        lineToRelative(-8.0f, -10.0f)
        lineToRelative(-8.0f, -6.0f)
        quadToRelative(-3.0f, -3.0f, -9.0f, -3.0f)
        lineToRelative(-6.0f, 1.0f)
        lineToRelative(-4.0f, 2.0f)
        quadTo(485.0f, 885.0f, 477.0f, 894.0f)
        lineTo(463.0f, 909.0f)
        quadTo(453.0f, 921.0f, 436.5f, 930.5f)
        quadTo(420.0f, 940.0f, 392.0f, 940.0f)
        lineTo(123.0f, 940.0f)
        lineTo(81.0f, 740.0f)
        lineToRelative(264.0f, -0.0f)
        lineToRelative(4.0f, -0.0f)
        lineToRelative(5.0f, -0.0f)
        lineToRelative(12.0f, -1.0f)
        quadToRelative(3.0f, -1.0f, 5.0f, -6.0f)
        quadToRelative(0.0f, -8.0f, -15.0f, -22.0f)
        lineToRelative(-32.0f, -37.0f)
        quadToRelative(-19.0f, -24.0f, -33.0f, -57.0f)
        quadToRelative(-14.0f, -33.0f, -14.0f, -80.0f)
        quadToRelative(0.0f, -59.0f, 21.0f, -101.5f)
        quadToRelative(21.0f, -42.5f, 48.0f, -74.0f)
        quadToRelative(27.0f, -31.5f, 48.5f, -49.5f)
        quadToRelative(21.5f, -18.0f, 22.5f, -25.0f)
        lineToRelative(-2.0f, -9.0f)
        lineToRelative(-3.0f, -14.0f)
        lineToRelative(-4.0f, -17.0f)
        lineToRelative(-1.0f, -23.0f)
        quadToRelative(0.0f, -33.0f, 29.0f, -60.5f)
        quadToRelative(29.0f, -27.5f, 64.0f, -27.5f)
        lineToRelative(5.0f, -0.0f)
        lineToRelative(5.0f, -0.0f)
        quadToRelative(29.0f, 3.0f, 55.5f, 31.0f)
        quadToRelative(26.5f, 28.0f, 26.5f, 68.0f)
        lineToRelative(-1.0f, 14.0f)
        quadToRelative(0.0f, 8.0f, -2.0f, 12.0f)
        lineToRelative(-4.0f, 11.0f)
        lineToRelative(-6.0f, 12.0f)
        lineToRelative(20.0f, 17.0f)
        lineToRelative(19.0f, 17.0f)
        quadTo(670.0f, 365.0f, 696.5f, 416.0f)
        quadTo(723.0f, 467.0f, 723.0f, 538.0f)
        quadTo(723.0f, 576.0f, 708.5f, 608.5f)
        quadTo(694.0f, 641.0f, 676.0f, 665.0f)
        lineToRelative(-33.0f, 42.0f)
        quadToRelative(-12.0f, 15.0f, -14.0f, 26.0f)
        quadToRelative(4.0f, 6.0f, 6.0f, 6.0f)
        lineToRelative(17.0f, 1.0f)
        lineToRelative(5.0f, -0.0f)
        lineToRelative(262.0f, -0.0f)
        close()
        moveTo(833.0f, 811.0f)
        lineTo(616.0f, 811.0f)
        quadToRelative(-26.0f, -0.0f, -46.0f, -17.5f)
        quadToRelative(-20.0f, -17.5f, -20.0f, -42.5f)
        lineToRelative(1.0f, -10.0f)
        lineToRelative(3.0f, -11.0f)
        quadToRelative(6.0f, -16.0f, 19.0f, -35.0f)
        lineToRelative(28.0f, -37.0f)
        quadToRelative(6.0f, -8.0f, 17.0f, -25.0f)
        quadToRelative(8.0f, -12.0f, 18.0f, -29.0f)
        quadToRelative(16.0f, -30.0f, 16.0f, -65.0f)
        quadToRelative(0.0f, -64.0f, -24.5f, -115.0f)
        quadTo(603.0f, 373.0f, 550.0f, 344.0f)
        quadTo(524.0f, 399.0f, 518.0f, 454.0f)
        lineToRelative(-5.0f, 85.0f)
        lineToRelative(0.0f, 8.0f)
        lineToRelative(0.0f, 6.0f)
        lineToRelative(-67.0f, -0.0f)
        lineToRelative(0.0f, -7.0f)
        quadToRelative(0.0f, -39.0f, 1.5f, -57.5f)
        quadToRelative(1.5f, -18.5f, 8.5f, -46.5f)
        quadToRelative(14.0f, -51.0f, 31.0f, -92.0f)
        lineToRelative(28.0f, -64.0f)
        quadToRelative(11.0f, -26.0f, 13.0f, -35.0f)
        lineToRelative(0.0f, -5.0f)
        quadToRelative(0.0f, -18.0f, -8.0f, -31.0f)
        quadToRelative(-6.0f, -14.0f, -24.0f, -14.0f)
        lineToRelative(-5.0f, -0.0f)
        quadToRelative(-9.0f, 1.0f, -19.0f, 11.0f)
        quadToRelative(-10.0f, 10.0f, -10.0f, 25.0f)
        lineToRelative(1.0f, 19.0f)
        lineToRelative(4.0f, 17.0f)
        lineToRelative(0.0f, 4.0f)
        lineToRelative(1.0f, 3.0f)
        lineToRelative(2.0f, 13.0f)
        lineToRelative(1.0f, 13.0f)
        quadToRelative(0.0f, 9.0f, -4.0f, 16.0f)
        lineTo(456.0f, 336.0f)
        lineTo(434.0f, 355.0f)
        quadTo(421.0f, 365.0f, 410.0f, 377.0f)
        quadTo(387.0f, 399.0f, 367.5f, 440.0f)
        quadTo(348.0f, 481.0f, 348.0f, 552.0f)
        quadTo(348.0f, 585.0f, 363.0f, 611.5f)
        quadTo(378.0f, 638.0f, 398.0f, 662.0f)
        lineToRelative(18.0f, 24.0f)
        lineToRelative(17.0f, 23.0f)
        lineToRelative(10.0f, 21.0f)
        lineToRelative(4.0f, 22.0f)
        quadTo(447.0f, 782.0f, 428.5f, 796.5f)
        quadTo(410.0f, 811.0f, 383.0f, 811.0f)
        lineTo(167.0f, 811.0f)
        lineToRelative(12.0f, 58.0f)
        lineToRelative(226.0f, -0.0f)
        quadToRelative(17.0f, -0.0f, 29.0f, -9.0f)
        lineToRelative(20.0f, -22.0f)
        lineToRelative(3.0f, -3.0f)
        lineToRelative(18.0f, -19.0f)
        quadToRelative(9.0f, -9.0f, 25.0f, -9.0f)
        quadToRelative(10.0f, -0.0f, 21.0f, 9.0f)
        lineToRelative(20.0f, 18.0f)
        lineToRelative(3.0f, 4.0f)
        lineToRelative(22.0f, 22.0f)
        quadToRelative(11.0f, 9.0f, 24.0f, 9.0f)
        lineToRelative(230.0f, -0.0f)
        close()
      }
      path(
        fill = SolidColor(fill), stroke = null, strokeLineWidth = 0.0f,
        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
        pathFillType = NonZero
      ) {
        moveToRelative(180.89f, 864.79f)
        curveToRelative(-1.0f, -1.75f, -3.12f, -10.81f, -4.71f, -20.13f)
        curveToRelative(-1.6f, -9.32f, -3.85f, -20.18f, -5.0f, -24.12f)
        curveToRelative(-1.93f, -6.6f, 7.51f, -7.28f, 117.81f, -8.47f)
        curveToRelative(135.46f, -1.47f, 142.36f, -2.91f, 154.59f, -32.18f)
        curveToRelative(13.15f, -31.47f, 3.15f, -58.49f, -45.02f, -121.66f)
        curveToRelative(-39.26f, -51.49f, -46.87f, -70.23f, -46.8f, -115.2f)
        curveToRelative(0.13f, -77.65f, 19.99f, -123.5f, 77.61f, -179.16f)
        curveToRelative(20.58f, -19.88f, 39.1f, -40.36f, 41.15f, -45.52f)
        curveToRelative(2.23f, -5.62f, 1.83f, -23.54f, -1.01f, -44.74f)
        curveToRelative(-5.52f, -41.23f, -3.0f, -55.47f, 11.46f, -64.95f)
        curveToRelative(14.11f, -9.25f, 29.97f, -4.72f, 38.02f, 10.86f)
        curveToRelative(9.24f, 17.87f, 8.08f, 29.22f, -6.56f, 64.33f)
        curveToRelative(-54.0f, 129.46f, -63.24f, 160.8f, -66.38f, 225.02f)
        lineToRelative(-2.22f, 45.55f)
        lineToRelative(36.56f, 0.0f)
        lineToRelative(36.56f, 0.0f)
        lineToRelative(0.0f, -32.95f)
        curveToRelative(0.0f, -63.39f, 14.86f, -141.67f, 31.13f, -163.91f)
        curveToRelative(5.78f, -7.91f, 6.37f, -7.93f, 17.53f, -0.61f)
        curveToRelative(20.32f, 13.31f, 47.17f, 44.4f, 58.72f, 68.0f)
        curveToRelative(23.48f, 47.95f, 31.16f, 120.53f, 16.81f, 158.99f)
        curveToRelative(-7.22f, 19.36f, -35.45f, 64.04f, -65.51f, 103.68f)
        curveToRelative(-22.16f, 29.22f, -30.86f, 56.09f, -25.09f, 77.52f)
        curveToRelative(4.91f, 18.22f, 21.62f, 36.39f, 39.78f, 43.26f)
        curveToRelative(7.35f, 2.78f, 55.81f, 4.51f, 126.34f, 4.51f)
        curveToRelative(112.39f, 0.0f, 114.37f, 0.15f, 112.01f, 8.47f)
        curveToRelative(-2.51f, 8.83f, -4.07f, 15.3f, -8.49f, 35.14f)
        lineToRelative(-2.64f, 11.84f)
        lineToRelative(-120.26f, -1.24f)
        lineToRelative(-120.26f, -1.24f)
        lineToRelative(-28.98f, -27.98f)
        curveToRelative(-43.99f, -42.48f, -55.36f, -43.15f, -91.12f, -5.37f)
        curveToRelative(-12.43f, 13.12f, -28.73f, 26.47f, -36.23f, 29.67f)
        curveToRelative(-10.39f, 4.42f, -40.3f, 5.8f, -125.81f, 5.8f)
        curveToRelative(-61.7f, 0.0f, -112.99f, -1.43f, -113.99f, -3.18f)
        close()
      }
    }
      .build()
  }
