package com.sparkle.artworks.list.view

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.sparkle.artworks.list.ArtworksViewModel

@Composable
internal fun ArtworksScreen(
    viewModel: ArtworksViewModel = hiltViewModel(),
    onItemClick: (artwork: Long) -> Unit
) {
    val artworks = viewModel.loadData().collectAsLazyPagingItems()

    ArtworksListView(
        artworks = artworks,
        onItemClick = { onItemClick(it) },
    )
}