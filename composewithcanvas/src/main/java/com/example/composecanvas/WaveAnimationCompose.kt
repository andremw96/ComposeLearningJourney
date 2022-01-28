package com.example.composecanvas

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.composecanvas.ui.theme.Purple500

@Composable
fun WaveAnimation() {
    val animColor by animateColorAsState(
        targetValue = Purple500,
        animationSpec = TweenSpec(0, easing = LinearEasing),
    )

    val deltaXAnim = rememberInfiniteTransition()
    val dx by deltaXAnim.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(500, easing = LinearEasing)
        )
    )

    val screenWidthPx = with(LocalDensity.current) {
        (LocalConfiguration.current.screenHeightDp * density)
    }
    val animTranslate by animateFloatAsState(
        targetValue = screenWidthPx,
        animationSpec = TweenSpec(10000, easing = LinearEasing)
    )

    val waveHeight by animateFloatAsState(
        targetValue = 0f,
        animationSpec = TweenSpec(10000, easing = LinearEasing)
    )

    val path = Path()
    val waveWidth = 200
    val originalY = 150f

    Canvas(modifier = Modifier.size(300.dp), onDraw = {
        translate(top = animTranslate) {
            drawPath(path = path, color = animColor)
            path.reset()
            val halfWaveWidth = waveWidth / 2
            path.moveTo(-waveWidth + (waveWidth * dx), originalY.dp.toPx())

            for (i in -waveWidth..(size.width.toInt() + waveWidth) step waveWidth) {
                path.relativeQuadraticBezierTo(
                    halfWaveWidth.toFloat() / 2,
                    -waveHeight,
                    halfWaveWidth.toFloat(),
                    0f
                )
                path.relativeQuadraticBezierTo(
                    halfWaveWidth.toFloat() / 2,
                    waveHeight,
                    halfWaveWidth.toFloat(),
                    0f
                )
            }

            path.lineTo(size.width, size.height)
            path.lineTo(0f, size.height)
            path.close()
        }
    })
}

