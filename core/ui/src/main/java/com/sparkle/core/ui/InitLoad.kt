package com.sparkle.core.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import java.util.concurrent.atomic.AtomicBoolean

@Composable
fun InitLoad(action: () -> Unit) {
    val shouldFetchData = rememberSaveable { AtomicBoolean(true) }
    if (shouldFetchData.getAndSet(false)) {
        action()
    }
}