package com.example.composecanvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecanvas.ui.theme.ComposeCanvasTheme
import com.example.composecanvas.ui.theme.Purple500
import com.example.composecanvas.ui.theme.Purple700
import com.example.composecanvas.ui.theme.Teal200

@Composable
fun SmileyFace() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(16.dp),
        onDraw = {
            drawCircle(
                brush = Brush.linearGradient(colors = listOf(Purple500, Purple700)),
                radius = size.width / 2,
                center = center,
                style = Stroke(width = size.width * 0.075f)
            )

            val smilePadding = size.width * 0.15f
            drawArc(
                color = Teal200,
                startAngle = 0f,
                sweepAngle = 180f,
                useCenter = true,
                topLeft = Offset(smilePadding, smilePadding),
                size = Size(size.width - (smilePadding * 2f), size.height - (smilePadding * 2f))
            )

            drawRect(
                color = Color.Black,
                topLeft = Offset(size.width * 0.25f, size.height / 4),
                size = Size(smilePadding, smilePadding)
            )

            drawRect(
                color = Color.Black,
                topLeft = Offset(size.width * 0.75f - smilePadding, size.height / 4),
                size = Size(smilePadding, smilePadding)
            )
        }
    )
}

@Preview
@Composable
fun SmilyeFacePreview() {
    ComposeCanvasTheme {
        SmileyFace()
    }
}
