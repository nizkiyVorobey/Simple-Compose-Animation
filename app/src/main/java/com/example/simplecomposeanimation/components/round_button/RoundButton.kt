package com.example.simplecomposeanimation.components.round_button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplecomposeanimation.R
import com.example.simplecomposeanimation.ui.theme.SimpleComposeAnimationTheme

sealed class RoundButtonType {
    object Add : RoundButtonType()
    object Minus : RoundButtonType()
    data class Number(val value: String) : RoundButtonType()
}

@Composable
fun RoundButton(
    onClick: () -> Unit,
    type: RoundButtonType,
    modifier: Modifier = Modifier,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
) {
    val image = when (type) {
        RoundButtonType.Add -> painterResource(R.drawable.add)
        RoundButtonType.Minus -> painterResource(R.drawable.remove)
        is RoundButtonType.Number -> painterResource(R.drawable.remove)
    }

    val color = when (type) {
        RoundButtonType.Add -> Color.Green
        RoundButtonType.Minus -> Color.DarkGray
        is RoundButtonType.Number -> Color.White
    }

    Column(modifier) {
        Button(
            onClick = onClick,
            shape = CircleShape,
            modifier = Modifier
                .width(55.dp)
                .height(55.dp),
            colors = buttonColors(backgroundColor = color),
            elevation=elevation
        ) {
            when (type) {
                RoundButtonType.Add,
                RoundButtonType.Minus -> {
                    Icon(
                        painter = image,
                        contentDescription = "ss",
                        tint = Color.White,
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                    )
                }
                is RoundButtonType.Number -> {
                    Text(text = type.value)
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun RoundButtonPreview() {
    SimpleComposeAnimationTheme {
        RoundButton(
            onClick = {},
            type = RoundButtonType.Add,
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RoundButtonPreview3() {
    SimpleComposeAnimationTheme {
        RoundButton(
            onClick = {},
            type = RoundButtonType.Number("1"),
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RoundButtonPreview2() {
    SimpleComposeAnimationTheme {
        RoundButton(
            onClick = {},
            type = RoundButtonType.Minus,
            modifier = Modifier
        )
    }
}