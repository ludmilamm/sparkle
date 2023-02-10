package com.sparkle.core.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sparkle.core.ui.Spacing
import com.sparkle.core.ui.SparkleTheme

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(all = Spacing.double),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

@Composable
@Preview
private fun LoadingViewPreview() {
    SparkleTheme {
        LoadingView()
    }
}
