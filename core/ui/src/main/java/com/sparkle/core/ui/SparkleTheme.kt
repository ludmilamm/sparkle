package com.sparkle.core.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun SparkleTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(content = content)
}