package com.example.simplecomposeanimation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.simplecomposeanimation.components.heart.AnimateHeart
import com.example.simplecomposeanimation.components.loading_circle.Loading
import com.example.simplecomposeanimation.components.loading_stripe.LoadingStripe
import com.example.simplecomposeanimation.components.round_button.ExpendedButtons
import com.example.simplecomposeanimation.ui.theme.SimpleComposeAnimationTheme

@Composable
fun App() {
    ExpendedButtons()
//    AnimateHeart()
//    Loading()
//    LoadingStripe()
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    SimpleComposeAnimationTheme {
        App()
    }
}