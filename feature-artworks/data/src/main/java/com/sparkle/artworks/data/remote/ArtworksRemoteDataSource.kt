package com.sparkle.artworks.data.remote

import com.sparkle.artworks.data.model.ArtworkDetailResponse
import com.sparkle.artworks.data.model.ArtworkResponse
import com.sparkle.artworks.data.model.ArtworkListResponse

internal interface ArtworksRemoteDataSource {

    suspend fun getArtworks(): Result<ArtworkListResponse>

    suspend fun getArtworks(nextPage: String): Result<ArtworkListResponse>

    suspend fun getArtwork(id: Long): Result<ArtworkDetailResponse>
}