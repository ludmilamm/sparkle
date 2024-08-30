package com.sparkle.artworks.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import javax.inject.Inject
import kotlin.math.roundToInt

class GetArtworksUseCase @Inject internal constructor(
    private val getArtworkPagingSource: GetArtworkPagingSource
) {

    companion object {
        private const val DEFAULT_PAGE_SIZE = 20
        private const val DEFAULT_PREFETCH_FRACTION = 0.3f
    }

    operator fun invoke(
        pageSize: Int = DEFAULT_PAGE_SIZE,
        prefetchFraction: Float = DEFAULT_PREFETCH_FRACTION
    ) = Pager(
        config = PagingConfig(
            pageSize = pageSize,
            prefetchDistance = (pageSize * prefetchFraction).roundToInt(),
            initialLoadSize = pageSize,
            enablePlaceholders = false
        )
    ) {
        getArtworkPagingSource
    }.flow
}