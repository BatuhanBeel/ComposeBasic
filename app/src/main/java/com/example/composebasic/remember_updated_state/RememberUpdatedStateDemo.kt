package com.example.composebasic.remember_updated_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun RememberUpdatedStateDemo(
    onTimeout: () -> Unit
){
    // This will always refer to the latest onTimeout function that
    // RememberUpdatedStateDemo was recomposed with
    val updatedOnTimeout by rememberUpdatedState(newValue = onTimeout)

    // Create an effect that matches the lifecycle of RememberUpdatedStateDemo.
    // If RememberUpdatedStateDemo recomposes, the delay shouldn't start again.
    LaunchedEffect(key1 = true){
        delay(3000L)
        updatedOnTimeout()
    }
}

