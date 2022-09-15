package com.example.simplecomposeanimation.components.loading_stripe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecomposeanimation.ui.theme.SimpleComposeAnimationTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun LoadingStripe() {
    val scope = rememberCoroutineScope()
    val state = rememberScrollState()

    var isLoading by remember { mutableStateOf(true) }
    var isStripeMount by remember { mutableStateOf(true) }

    fun setIsStripeMount(value: Boolean) {
        isStripeMount = value
    }

    LaunchedEffect(Unit) {
        scope.launch {
            delay(5000)
            isLoading = false
        }
    }

    Column(Modifier.verticalScroll(state)) {
        repeat(40) {
            Text(text = "Hello world")
        }
    }

    if (isStripeMount) {
        Stripe(isLoading = isLoading, setIsStripeMount = ::setIsStripeMount)
    }

    val text =
        if (isLoading) "Content is loading..."
        else if (!isLoading && isStripeMount) "content loaded but not visible"
        else "content is visible"
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        Text(
            text = text,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(15.dp))
                .background(Color.White)
                .padding(15.dp)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoadingStripePreview() {
    SimpleComposeAnimationTheme {
        LoadingStripe()
    }
}
