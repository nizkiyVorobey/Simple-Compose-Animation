package com.example.simplecomposeanimation.components.loading_circle

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplecomposeanimation.ui.theme.SimpleComposeAnimationTheme


@Composable
fun Loading() {
    val alpha = remember { Animatable(1f) }
    val scale = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        // make start animation and then reverse
//        scale.animateTo(
//            3f,
//            animationSpec = infiniteRepeatable(
//                keyframes {
//                    durationMillis=3000
//                    0f at 0 with LinearEasing
//                    3f at 2000 with LinearEasing
//                    0f at 3000 with LinearEasing
//                },
//                repeatMode = RepeatMode.Restart
//            )
//        )

        scale.animateTo(
            3f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(Unit) {
        alpha.animateTo(
            0f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.Yellow)
    ) {
        Box(
            modifier = Modifier
                .scale(scale.value)
                .alpha(alpha.value)
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Blue)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoadingPreview() {
    SimpleComposeAnimationTheme {
        Loading()
    }
}