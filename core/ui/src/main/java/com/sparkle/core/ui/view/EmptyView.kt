package com.sparkle.core.ui.view

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RoundedCorner
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sparkle.core.ui.R
import com.sparkle.core.ui.SparkleTheme

@Composable
fun EmptyView(@StringRes message: Int = R.string.empty_message) {
    IconView(
        icon = Icons.Default.RoundedCorner,
        label = message,
        modifier = Modifier.fillMaxSize()
    )
}

@Preview
@Composable
fun EmptyViewPreview() {
    SparkleTheme {
        EmptyView()
    }
}