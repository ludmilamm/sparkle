package com.sparkle.artworks.data

import com.sparkle.artworks.data.mapper.toDomain
import com.sparkle.artworks.data.remote.ArtworksRemoteDataSource
import com.sparkle.artworks.domain.repository.ArtworksRepository
import com.sparkle.artworks.domain.repository.model.Artwork
import com.sparkle.artworks.domain.repository.model.Artworks
import javax.inject.Inject

internal class ArtworksRepositoryImpl @Inject constructor(
    private val remoteDataSource: ArtworksRemoteDataSource
) : ArtworksRepository {

    override suspend fun getArtworks(): Result<Artworks> {
        return remoteDataSource.getArtworks().mapCatching { it.toDomain() }
    }

    override suspend fun getArtworks(nextPage: String?): Result<Artworks> {
        return if (nextPage == null) {
            getArtworks()
        } else {
            remoteDataSource.getArtworks(nextPage).mapCatching { it.toDomain() }
        }
    }

    override suspend fun getArtwork(id: Long): Result<Artwork> {
        return remoteDataSource.getArtwork(id).mapCatching { it.toDomain() }
    }
}