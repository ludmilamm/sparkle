package com.sparkle.artworks.list.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sparkle.artworks.list.model.ArtworkItemUiModel
import com.sparkle.core.ui.SparkleTheme

@Composable
internal fun ArtworkItemView(artwork: ArtworkItemUiModel, onClick: (artwork: Long) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onClick(artwork.id) }
    ) {
        LinearProgressIndicator(Modifier.height(1.dp))

        AsyncImage(
            model = artwork.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun ArtworkItemViewPreview() {
    val artwork = ArtworkItemUiModel(id = 0, imageUrl = "")
    SparkleTheme() {
        ArtworkItemView(artwork) {}
    }
}