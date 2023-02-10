package com.sparkle.artworks.detail

import com.sparkle.artworks.detail.model.ArtworkDetailUiModel

internal sealed interface ArtworkDetailState {

    object Idle : ArtworkDetailState

    object Loading : ArtworkDetailState

    data class Loaded(val artwork: ArtworkDetailUiModel) : ArtworkDetailState

    object Error : ArtworkDetailState
}