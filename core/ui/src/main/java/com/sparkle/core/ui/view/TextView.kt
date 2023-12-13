package com.sparkle.core.ui.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.sparkle.core.ui.FontSize
import com.sparkle.core.ui.SparkleTheme

@Composable
fun TitleView(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = FontSize.large,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun SubtitleView(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = FontSize.medium,
        fontWeight = FontWeight.Light,
        modifier = modifier
    )
}

@Composable
fun NormalTextView(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = FontSize.normal,
        fontWeight = FontWeight.Normal,
        modifier = modifier
    )
}

@Composable
fun SmallTextView(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = FontSize.small,
        fontWeight = FontWeight.ExtraLight,
        fontStyle = FontStyle.Italic,
        modifier = modifier
    )
}

@Preview
@Composable
fun TitleViewPreview() {
    SparkleTheme {
        TitleView("Title", Modifier.fillMaxWidth())
    }
}

@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
fun SubtitleViewPreview() {
    SparkleTheme {
        SubtitleView("Subtitle", Modifier.fillMaxWidth())
    }
}

@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
fun NormalTextViewPreview() {
    SparkleTheme {
        NormalTextView("Normal", Modifier.fillMaxWidth())
    }
}

@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
fun SmallTextViewPreview() {
    SparkleTheme {
        SmallTextView("Small", Modifier.fillMaxWidth())
    }
}