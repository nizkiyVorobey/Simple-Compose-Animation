package com.example.simplecomposeanimation.components.loading_stripe

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplecomposeanimation.ui.theme.SimpleComposeAnimationTheme

val animationDuration = 2000

@Composable
fun Stripe(
    isLoading: Boolean,
    setIsStripeMount: (value: Boolean) -> Unit,
) {
    val offsetY = remember { Animatable(0f) }
    val loadingWrapperOffset = remember { Animatable(0f) }
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp.value

    LaunchedEffect(isLoading) {
        while (isLoading) {
            offsetY.animateTo(
                screenHeight - 100,
                tween(durationMillis = animationDuration, easing = LinearEasing)
            )
            offsetY.snapTo(0f)
        }

        val durationPerDp = animationDuration/(screenHeight - 100)
        val leftOffset = (screenHeight - 100) - offsetY.value
        val time = leftOffset * durationPerDp
        Log.d("Stripe", "time: ${time}")

        offsetY.animateTo(
            screenHeight - 100,
            tween(durationMillis = time.toInt(), easing = LinearEasing)
        )
        offsetY.snapTo(0f)
        loadingWrapperOffset.animateTo(screenHeight,tween(durationMillis = animationDuration, easing = LinearEasing) )

        setIsStripeMount(false)
    }


//    offsetY.animateTo(
//        screenHeight - 100,
//        animationSpec = infiniteRepeatable(
//            animation = tween(
//                durationMillis = 2000,
//                easing = LinearEasing
//            ),
//            repeatMode = RepeatMode.Restart
//        )
//    )

//    LaunchedEffect(Unit) {
//        offsetY.animateTo(
//            screenHeight - 100,
//            tween(
//                durationMillis = 3000,
//                easing = LinearEasing
//            )
//        )
//
//        offsetY.snapTo(300f)
//        Log.d("Stripe", "S")
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .offset(y=loadingWrapperOffset.value.dp)
            .background(Color.Green)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .offset(y = offsetY.value.dp)
                .background(Color.Gray)

        ) {}
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StripePreview() {
    SimpleComposeAnimationTheme {
        Stripe(
            isLoading = true,
            setIsStripeMount = {}
        )
    }
}