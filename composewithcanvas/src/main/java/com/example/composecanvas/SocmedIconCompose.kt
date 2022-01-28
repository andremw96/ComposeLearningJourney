package com.example.composecanvas

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecanvas.ui.theme.ComposeCanvasTheme

@Composable
fun InstagramIcon() {
    val instaColors = listOf(Color.Yellow, Color.Red, Color.Magenta)
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp),
        onDraw = {
            drawRoundRect(
                brush = Brush.linearGradient(colors = instaColors),
                cornerRadius = CornerRadius(60f, 60f),
                style = Stroke(width = 15f, cap = StrokeCap.Round)
            )

            drawCircle(
                brush = Brush.linearGradient(colors = instaColors),
                radius = 45f,
                style = Stroke(width = 15f, cap = StrokeCap.Round)
            )

            drawCircle(
                brush = Brush.linearGradient(colors = instaColors),
                radius = 13f,
                center = Offset(this.size.width * 0.80f, this.size.height * 0.20f)
            )
        }
    )
}

@Composable
fun FacebookIcon() {
    val assetManager = LocalContext.current.assets
    val paint = Paint().apply {
        textAlign = Paint.Align.CENTER
        textSize = 200f
        color = Color.White.toArgb()
    }

    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp),
        onDraw = {
            drawRoundRect(
                color = Color(0xFF1776d1),
                cornerRadius = CornerRadius(20f, 20f)
            )
            drawContext.canvas.nativeCanvas.drawText("f", center.x + 25, center.y + 90, paint)
        }
    )
}

@Composable
fun MessengerIcon() {
    val colors = listOf(Color(0xFF02b8f9), Color(0xFF0277fe))
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp),
        onDraw = {
            val trianglePath = Path().let {
                it.moveTo(this.size.width * 0.20f, this.size.height * 0.77f)
                it.lineTo(this.size.width * 0.20f, this.size.height * 0.95f)
                it.lineTo(this.size.width * 0.37f, this.size.height * 0.86f)
                it.close()
                it
            }

            val electricPath = Path().let {
                it.moveTo(this.size.width * 0.20f, this.size.height * 0.60f)
                it.lineTo(this.size.width * 0.45f, this.size.height * 0.35f)
                it.lineTo(this.size.width * 0.56f, this.size.height * 0.46f)
                it.lineTo(this.size.width * 0.78f, this.size.height * 0.35f)
                it.lineTo(this.size.width * 0.54f, this.size.height * 0.60f)
                it.lineTo(this.size.width * 0.43f, this.size.height * 0.45f)
                it.close()
                it
            }

            drawOval(
                brush = Brush.verticalGradient(colors = colors),
                size = Size(this.size.width, this.size.height * 0.95f)
            )

            drawPath(
                path = trianglePath,
                brush = Brush.verticalGradient(colors = colors),
                style = Stroke(width = 15f)
            )

            drawPath(
                path = electricPath,
                color = Color.White
            )
        }
    )
}

@Composable
fun GooglePhotosIcon() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp),
        onDraw = {
            drawArc(
                color = Color(0xFFf04231),
                startAngle = -90f,
                sweepAngle = 180f,
                useCenter = true,
                size = Size(size.width * 0.50f, size.height * 0.50f),
                topLeft = Offset(size.width * 0.25f, 0f)
            )

            drawArc(
                color = Color(0xFF4385f7),
                startAngle = 0f,
                sweepAngle = 180f,
                useCenter = true,
                size = Size(size.width * 0.50f, size.height * 0.50f),
                topLeft = Offset(size.width * 0.50f, size.height * 0.25f)
            )

            drawArc(
                color = Color(0xFFffbf00),
                startAngle = 270f,
                sweepAngle = -180f,
                useCenter = true,
                size = Size(size.width * 0.50f, size.height * 0.50f),
                topLeft = Offset(size.width * 0.25f, size.height * 0.50f)
            )

            drawArc(
                color = Color(0xFF30a952),
                startAngle = 0f,
                sweepAngle = -180f,
                useCenter = true,
                size = Size(size.width * 0.50f, size.height * 0.50f),
                topLeft = Offset(0f, size.height * 0.25f)
            )
        }
    )
}

@Composable
fun WeatherIcon() {
    val bgColor = listOf(Color(0xFF2078EE), Color(0xFF74E6FE))
    val sunColor = listOf(Color(0xFFFFC200), Color(0xFFFFE100))

    Canvas(modifier = Modifier
        .size(100.dp)
        .padding(16.dp),
        onDraw = {
            val width = size.width
            val height = size.height

            val cloudPath = Path().apply {
                moveTo(width * 0.76f, height * 0.72f)
                cubicTo(
                    width * 0.93f,
                    height * 0.72f,
                    width * 0.98f,
                    height * 0.41f,
                    width * 0.76f,
                    height * 0.40f
                )

                cubicTo(
                    width * 0.75f,
                    height * 0.21f,
                    width * 0.35f,
                    height * 0.21f,
                    width * 0.38f,
                    height * 0.50f
                )

                cubicTo(
                    width * 0.25f,
                    height * 0.50f,
                    width * 0.20f,
                    height * 0.69f,
                    width * 0.41f,
                    height * 0.72f
                )

                close()
            }

            drawRoundRect(
                brush = Brush.verticalGradient(bgColor),
                cornerRadius = CornerRadius(50f, 50f),
            )

            drawCircle(
                brush = Brush.verticalGradient(sunColor),
                radius = width * 0.17f,
                center = Offset(width * 0.35f, height * 0.35f)
            )

            drawPath(cloudPath, color = Color.White.copy(alpha = 0.90f))
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCanvasTheme {
        Column {
            InstagramIcon()

            Spacer(
                modifier = Modifier
                    .height(2.dp)
                    .width(100.dp)
                    .background(Color.Black)
            )

            FacebookIcon()

            Spacer(
                modifier = Modifier
                    .height(2.dp)
                    .width(100.dp)
                    .background(Color.Black)
            )

            MessengerIcon()

            Spacer(
                modifier = Modifier
                    .height(2.dp)
                    .width(100.dp)
                    .background(Color.Black)
            )

            GooglePhotosIcon()

            Spacer(
                modifier = Modifier
                    .height(2.dp)
                    .width(100.dp)
                    .background(Color.Black)
            )

            WeatherIcon()
        }
    }
}
