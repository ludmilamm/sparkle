package com.sparkle.artworks.domain

import com.sparkle.artworks.domain.repository.ArtworksRepository
import com.sparkle.artworks.domain.repository.model.Artworks
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetArtworksUseCase @Inject constructor(
    private val repository: ArtworksRepository
) {

    operator fun invoke(nextPage: String? = null): Flow<Result<Artworks>> {
        return if (nextPage == null) {
            flow { emit(repository.getArtworks()) }
        } else {
            flow { emit(repository.getArtworks(nextPage)) }
        }
    }
}