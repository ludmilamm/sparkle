package com.sparkle.core.ui.view

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SentimentDissatisfied
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sparkle.core.ui.FontSize
import com.sparkle.core.ui.R
import com.sparkle.core.ui.SparkleTheme

@Composable
fun ErrorView(
    @StringRes message: Int = R.string.error_message,
    tryAgain: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        IconView(
            icon = Icons.Default.SentimentDissatisfied,
            label = message,
            modifier = Modifier.wrapContentSize()
        )

        Button(
            onClick = { tryAgain() }
        ) {
            Text(
                text = stringResource(id = R.string.error_try_again),
                fontSize = FontSize.normal
            )
        }
    }
}

@Preview
@Composable
fun ErrorViewPreview() {
    SparkleTheme {
        ErrorView() {}
    }
}