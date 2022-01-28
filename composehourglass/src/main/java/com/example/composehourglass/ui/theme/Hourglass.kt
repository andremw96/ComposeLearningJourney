package com.example.composehourglass.ui.theme

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Hourglass() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val scale =
            scaleShapeTransition(initialValue = 0.1f, targetValue = 1f, durationMillis = 2000)
        val lineColor = colorShapeTransition(
            initialValue = grey900,
            targetValue = grey100,
            durationMillis = 2000
        )

        RoundRectangle(scale = scale, color = lineColor)
        MiddleLine(scale = scale, lineColor = lineColor)
        RoundRectangle(scale = scale, color = lineColor)
    }
}

@Composable
fun RoundRectangle(
    scale: Float,
    color: Color
) {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        },
        onDraw = {
            drawRoundRect(
                size = size / 2f,
                cornerRadius = CornerRadius(60f, 60f),
                color = color,
                style = Stroke(width = 16f),
                topLeft = Offset(size.width / 4f, size.height / 3f)
            )
        }
    )
}

@Composable
fun MiddleLine(
    scale: Float,
    lineColor: Color
) {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(180.dp)
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        },
        onDraw = {
            // Left top
            drawSingleLine(340f, -20f, 340f, 140f, lineColor, this)
            // Left top diagonal
            drawSingleLine(340f, 140f, 460f, 260f, lineColor, this)
            // Left bottom diagonal
            drawSingleLine(460f, 260f, 340f, 380f, lineColor, this)
            // Left bottom
            drawSingleLine(340f, 380f, 340f, 540f, lineColor, this)
            // Right bottom
            drawSingleLine(740f, 380f, 740f, 540f, lineColor, this)
            // Right top diagonal
            drawSingleLine(740f, 140f, 620f, 260f, lineColor, this)
            // Right bottom diagonal
            drawSingleLine(620f, 260f, 740f, 380f, lineColor, this)
            // Right top
            drawSingleLine(740f, -20f, 740f, 140f, lineColor, this)
        }
    )
}

fun drawSingleLine(
    startX: Float,
    startY: Float,
    endX: Float,
    endY: Float,
    lineColor: Color,
    drawScope: DrawScope
) {
    drawScope.drawLine(
        start = Offset(startX, startY),
        end = Offset(endX, endY),
        color = lineColor,
        strokeWidth = 16f,
        cap = StrokeCap.Round
    )
}

@Composable
fun colorShapeTransition(
    initialValue: Color,
    targetValue: Color,
    durationMillis: Int
): Color {
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = durationMillis, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    return color
}

@Composable
fun scaleShapeTransition(
    initialValue: Float,
    targetValue: Float,
    durationMillis: Int
): Float {
    val infiniteTransition = rememberInfiniteTransition()
    val scale: Float by infiniteTransition.animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = durationMillis),
            repeatMode = RepeatMode.Restart
        )
    )

    return scale
}

@Preview
@Composable
fun HourglasPreview() {
    ComposeHourglassTheme {
        Hourglass()
    }
}
