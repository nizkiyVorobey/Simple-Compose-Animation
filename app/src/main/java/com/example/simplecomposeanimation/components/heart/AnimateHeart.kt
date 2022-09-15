package com.example.simplecomposeanimation.components.heart

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplecomposeanimation.ui.theme.SimpleComposeAnimationTheme
import kotlinx.coroutines.*

@Composable
fun AnimateHeart() {
    var alpha by remember { mutableStateOf(0f) }
    var scale by remember { mutableStateOf(0f) }

    val scope = rememberCoroutineScope()
    val EaseInBack: Easing = CubicBezierEasing(0.36f, 0f, 0.66f, -0.56f)

    fun animateHeart() {
        // cancel all animation
        scope.coroutineContext.cancelChildren()

        scope.launch {
            coroutineScope {
                launch {
                    animate(
                        0f, 1f,
                        animationSpec = tween(
                            durationMillis = 1000,
                            easing = FastOutSlowInEasing
                        ),
                    ) { value, _ -> alpha = value }
                }

                launch {
                    animate(
                        0f, 1f,
                        animationSpec = tween(
                            durationMillis = 1000,
                            easing = FastOutSlowInEasing
                        ),
                    ) { value, _ -> scale = value }

                }
            }

            coroutineScope {
                launch {
                    animate(
                        .5f, 0f,
                        animationSpec = tween(
                            durationMillis = 1000,
                            easing = LinearEasing
                        ),
                    ) { value, _ -> alpha = value }

                }

                launch {
                    animate(
                        2f, 4f,
                        animationSpec = tween(
                            durationMillis = 1000,
                            easing = EaseInBack
                        ),
                    ) { value, _ -> scale = value }

                }
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Heart(
            modifier = Modifier
                .scale(scale)
                .alpha(alpha)

        )

        Button(onClick = { animateHeart() }, modifier = Modifier.padding(top = 100.dp)) {
            Text(text = "Animate heart")
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AnimateHeartPreview() {
    SimpleComposeAnimationTheme {
        AnimateHeart()
    }
}