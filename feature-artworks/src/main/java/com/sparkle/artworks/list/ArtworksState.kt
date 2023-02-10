package com.sparkle.artworks.list

import com.sparkle.artworks.list.model.ArtworkItemUiModel

internal sealed interface ArtworksState {

    object Idle : ArtworksState

    object Loading : ArtworksState

    sealed interface Success : ArtworksState {

        data class Loaded(
            val artworks: List<ArtworkItemUiModel>,
            val nextPageUrl: String?
        ) : Success

        object LoadingMore : Success
    }

    object Empty : ArtworksState

    object Error : ArtworksState
}