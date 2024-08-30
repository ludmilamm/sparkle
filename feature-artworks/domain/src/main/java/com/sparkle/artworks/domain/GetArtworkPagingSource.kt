package com.sparkle.artworks.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sparkle.artworks.domain.repository.ArtworksRepository
import com.sparkle.artworks.domain.repository.model.Artwork
import javax.inject.Inject

internal class GetArtworkPagingSource @Inject constructor(
    private val repository: ArtworksRepository
) : PagingSource<String, Artwork>() {

    override fun getRefreshKey(state: PagingState<String, Artwork>): String? = null

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Artwork> {
        val response = repository.getArtworks(params.key)

        return response.fold(
            onSuccess = { data ->
                LoadResult.Page(
                    data = data.artworks,
                    nextKey = data.pagination.nextUrl,
                    prevKey = params.key
                )
            },
            onFailure = {
                LoadResult.Error(it)
            }
        )
    }
}