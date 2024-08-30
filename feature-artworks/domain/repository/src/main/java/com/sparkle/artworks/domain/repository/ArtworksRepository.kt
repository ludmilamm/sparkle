package com.sparkle.artworks.domain.repository

import com.sparkle.artworks.domain.repository.model.Artwork
import com.sparkle.artworks.domain.repository.model.Artworks

interface ArtworksRepository {

    suspend fun getArtworks(): Result<Artworks>

    suspend fun getArtworks(nextPage: String?): Result<Artworks>

    suspend fun getArtwork(id: Long): Result<Artwork>
}