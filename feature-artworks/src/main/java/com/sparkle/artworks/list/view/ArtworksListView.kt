package com.sparkle.artworks.list.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sparkle.artworks.list.ArtworksState
import com.sparkle.artworks.list.model.ArtworkItemUiModel
import com.sparkle.core.ui.Spacing
import com.sparkle.core.ui.view.LoadingView

@Composable
internal fun ArtworksListView(
    state: ArtworksState.Success,
    onItemClick: (artwork: Long) -> Unit,
    loadNextPage: (nextPageUrl: String?, currentList: List<ArtworkItemUiModel>) -> Unit
) {
    val lazyGridState = rememberLazyGridState()
    val spanSize = 3

    LazyVerticalGrid(
        state = lazyGridState,
        columns = GridCells.Fixed(spanSize),
        verticalArrangement = Arrangement.spacedBy(Spacing.single),
        horizontalArrangement = Arrangement.spacedBy(Spacing.single),
        contentPadding = PaddingValues(top = Spacing.quadriple)
    ) {
        if (state is ArtworksState.Success.Loaded) {
            val artworks = state.artworks

            itemsIndexed(artworks, key = { _, item -> item.id }) { index, item ->
                ArtworkItemView(artwork = item, onClick = onItemClick)
            }
        }

        item(span = { GridItemSpan(spanSize) }) {
            if (state is ArtworksState.Success.LoadingMore) {
                LoadingView(Modifier.fillMaxWidth())
            }
        }
    }
}