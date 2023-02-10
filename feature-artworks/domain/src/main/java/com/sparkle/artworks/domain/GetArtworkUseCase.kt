package com.sparkle.artworks.domain

import com.sparkle.artworks.domain.repository.ArtworksRepository
import com.sparkle.artworks.domain.repository.model.Artwork
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetArtworkUseCase @Inject constructor(
    private val repository: ArtworksRepository
) {

    operator fun invoke(id: Long): Flow<Result<Artwork>> {
        return flow { emit(repository.getArtwork(id)) }
    }
}