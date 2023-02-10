package com.sparkle.artworks.detail.view

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.sparkle.artworks.detail.model.ArtworkDetailUiModel

@Composable
internal fun ArtworkDetailView(artworkUiModel: ArtworkDetailUiModel) {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (imageRef, cardRef) = createRefs()

        AsyncImage(
            model = artworkUiModel.imageUrl,
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(imageRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(cardRef.top)
                }

        )

        ArtworkDescriptionView(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .defaultMinSize(minHeight = 100.dp)
                .constrainAs(cardRef) {
                    bottom.linkTo(parent.bottom)
                },
            artworkUiModel = artworkUiModel
        )
    }
}