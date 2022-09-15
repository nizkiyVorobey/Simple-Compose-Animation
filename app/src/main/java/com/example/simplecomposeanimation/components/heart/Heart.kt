package com.example.simplecomposeanimation.components.heart

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplecomposeanimation.R
import com.example.simplecomposeanimation.ui.theme.SimpleComposeAnimationTheme

@Composable
fun Heart(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.heart),
            contentDescription = "Heart",
            tint = Color.Red,
            modifier = modifier.size(70.dp)
        )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeartPreview() {
    SimpleComposeAnimationTheme {
        Heart(modifier = Modifier)
    }
}