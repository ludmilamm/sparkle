package com.sparkle.artworks.list.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.sparkle.artworks.list.model.ArtworkItemUiModel
import com.sparkle.core.ui.Spacing
import com.sparkle.core.ui.view.EmptyView
import com.sparkle.core.ui.view.ErrorView
import com.sparkle.core.ui.view.LoadingView

@Composable
internal fun ArtworksListView(
    artworks: LazyPagingItems<ArtworkItemUiModel>,
    onItemClick: (artwork: Long) -> Unit
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
        items(artworks.itemCount) { index ->
            artworks[index]?.let {
                ArtworkItemView(artwork = it, onClick = onItemClick)
            }
        }

        with(artworks) {
            when {
                loadState.refresh is LoadState.Loading -> item(span = { GridItemSpan(spanSize) }) {
                    LoadingView(Modifier.fillMaxWidth())
                }
                loadState.refresh is LoadState.NotLoading && artworks.itemCount == 0 -> item(span = { GridItemSpan(spanSize) }) {
                    EmptyView()
                }
                loadState.refresh is LoadState.Error -> item(span = { GridItemSpan(spanSize) }) {
                    ErrorView { TODO() }
                }
                loadState.append is LoadState.Loading -> item(span = { GridItemSpan(spanSize) }) {
                    LoadingView(Modifier.wrapContentHeight())
                }
            }
        }
    }
}