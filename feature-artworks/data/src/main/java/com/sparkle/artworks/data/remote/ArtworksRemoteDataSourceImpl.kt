package com.sparkle.artworks.data.remote

import com.sparkle.artworks.data.model.ArtworkDetailResponse
import com.sparkle.artworks.data.model.ArtworkListResponse
import javax.inject.Inject

internal class ArtworksRemoteDataSourceImpl @Inject constructor(
    private val api: ArtworksApi
) : ArtworksRemoteDataSource {

    companion object {
        const val FIELDS_QUERY = "id,title,artist_title,image_id,date_end,medium_display"
        const val LIMIT_QUERY = 100
    }

    override suspend fun getArtworks(): Result<ArtworkListResponse> {
        return Result.runCatching { api.getArtworks(FIELDS_QUERY, LIMIT_QUERY) }
    }

    override suspend fun getArtworks(nextPage: String): Result<ArtworkListResponse> {
        return Result.runCatching { api.getArtworks(nextPage, FIELDS_QUERY, LIMIT_QUERY) }
    }

    override suspend fun getArtwork(id: Long): Result<ArtworkDetailResponse> {
        return Result.runCatching { api.getArtwork(id, FIELDS_QUERY, LIMIT_QUERY) }
    }
}