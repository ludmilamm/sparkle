package com.sparkle.artworks

import com.sparkle.artworks.detail.model.ArtworkDetailUiModel
import com.sparkle.artworks.domain.repository.model.Artwork
import com.sparkle.artworks.list.model.ArtworkItemUiModel

internal fun Artwork.toDetailUiModel() = ArtworkDetailUiModel(
    id = id,
    title = title,
    artistTitle = artistTitle,
    imageUrl = imageUrl,
    date = date,
    description = description
)

internal fun Artwork.toItemUiModel() = ArtworkItemUiModel(
    id = id,
    imageUrl = imageUrl
)