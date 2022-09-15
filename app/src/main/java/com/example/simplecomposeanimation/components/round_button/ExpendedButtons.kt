package com.example.simplecomposeanimation.components.round_button

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.simplecomposeanimation.ui.theme.SimpleComposeAnimationTheme

@Composable
fun ExpendedButtons() {
    var count by remember {
        mutableStateOf(0)
    }

    var isExpanded by remember {
        mutableStateOf(false)
    }
    val transition = updateTransition(isExpanded, label = "buttonTranition")

    fun getEasing():
            FiniteAnimationSpec<Dp> = tween(
        durationMillis = 300,
        easing = FastOutSlowInEasing
    )


    val offsetYPlus by transition.animateDp(
        label = "offsetYPlus",
        targetValueByState = { state ->
            when (state) {
                true -> -((55 + 25) * 2).dp
                false -> 0.dp
            }
        },
        transitionSpec = { getEasing() },
    )
    val offsetYNumber by transition.animateDp(
        label = "offsetYNumber",
        targetValueByState = { state ->
            when (state) {
                true -> -(55 + 25).dp
                false -> 0.dp
            }
        },
        transitionSpec = { getEasing() },
    )


    val animaElevation by transition.animateDp(
        label = "elevation",
        targetValueByState = { state ->
            when (state) {
                true -> 5.dp
                false -> 0.dp
            }
        },
        transitionSpec = { getEasing() },
    )


    fun handlePlusPress() {
        count++
        isExpanded = true
    }

    fun handleMinusPress() {
        var newValue = count - 1
        if (newValue < 0) newValue = 0
        count = newValue


        if (count == 0) {
            isExpanded = false
        }
    }

    Box(contentAlignment = Alignment.Center) {
        RoundButton(onClick = { handleMinusPress() }, type = RoundButtonType.Minus)
        RoundButton(
            onClick = { },
            type = RoundButtonType.Number(count.toString()),
            modifier = Modifier.offset(y = offsetYNumber),
            elevation = elevation(defaultElevation = animaElevation)
        )
        RoundButton(
            onClick = { handlePlusPress() },
            type = RoundButtonType.Add,
            modifier = Modifier.offset(y = offsetYPlus),
            elevation = elevation(defaultElevation = animaElevation)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ExpendedButtonsPreview() {
    SimpleComposeAnimationTheme {
        ExpendedButtons()
    }
}