package com.sparkle.artworks.detail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.sparkle.artworks.detail.model.ArtworkDetailUiModel
import com.sparkle.core.ui.Spacing
import com.sparkle.core.ui.SparkleTheme
import com.sparkle.core.ui.view.NormalTextView
import com.sparkle.core.ui.view.SmallTextView
import com.sparkle.core.ui.view.SubtitleView
import com.sparkle.core.ui.view.TitleView

@Composable
internal fun ArtworkDescriptionView(modifier: Modifier, artworkUiModel: ArtworkDetailUiModel) {
    Column(modifier = modifier) {
        val topShape = RoundedCornerShape(
            topStart = Spacing.double,
            topEnd = Spacing.double
        )

        Column(
            Modifier
                .clip(topShape)
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            TitleView(
                text = artworkUiModel.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Spacing.double)
                    .padding(top = Spacing.quadriple)
                    .clip(topShape)
            )

            SubtitleView(
                text = artworkUiModel.artistTitle,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Spacing.double)
                    .padding(bottom = Spacing.double)
            )

            SmallTextView(
                text = artworkUiModel.date.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Spacing.double)
                    .padding(bottom = Spacing.single)
            )

            NormalTextView(
                text = artworkUiModel.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Spacing.double)
                    .padding(bottom = Spacing.double)
            )

            Spacer(modifier = modifier.height(Spacing.quadriple))
        }
    }
}

@Preview
@Composable
fun ArtworkDescriptionViewPreview() {
    SparkleTheme {
        val artworkUiModel = ArtworkDetailUiModel(
            id = 0,
            title = "Sunflowers",
            artistTitle = "Van Gogh",
            imageUrl = "",
            date = 1980,
            description = "A bunch of sunflowers"
        )
        ArtworkDescriptionView(modifier = Modifier.fillMaxWidth(), artworkUiModel)
    }
}