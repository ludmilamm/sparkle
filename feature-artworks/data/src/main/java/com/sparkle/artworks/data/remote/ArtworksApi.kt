package com.sparkle.artworks.data.remote

import com.sparkle.artworks.data.model.ArtworkDetailResponse
import com.sparkle.artworks.data.model.ArtworkListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

internal interface ArtworksApi {

    @GET("artworks")
    suspend fun getArtworks(
        @Query("fields") fields: String,
        @Query("limit") limit: Int
    ): ArtworkListResponse

    @GET
    suspend fun getArtworks(
        @Url nextPage: String,
        @Query("fields") fields: String,
        @Query("limit") limit: Int
    ): ArtworkListResponse

    @GET("artworks/{id}")
    suspend fun getArtwork(
        @Path("id") id: Long,
        @Query("fields") fields: String,
        @Query("limit") limit: Int
    ): ArtworkDetailResponse
}