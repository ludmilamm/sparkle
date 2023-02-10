package com.sparkle.artworks.list.view

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.sparkle.artworks.list.ArtworksState
import com.sparkle.artworks.list.ArtworksViewModel
import com.sparkle.core.ui.view.EmptyView
import com.sparkle.core.ui.view.ErrorView
import com.sparkle.core.ui.view.InitLoad
import com.sparkle.core.ui.view.LoadingView

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun ArtworksScreen(
    viewModel: ArtworksViewModel = hiltViewModel(),
    onItemClick: (artwork: Long) -> Unit
) {
    val state by viewModel.state.collectAsState()

    InitLoad {
        viewModel.loadData()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        AnimatedContent(targetState = state) {
            when (state) {
                is ArtworksState.Loading, is ArtworksState.Idle -> LoadingView(Modifier.fillMaxSize())
                is ArtworksState.Success -> {
                    val successState = state as ArtworksState.Success
                    ArtworksListView(
                        state = successState,
                        onItemClick = { onItemClick(it) },
                        loadNextPage = { nextPageUrl, currentList ->
                            viewModel.loadNextPage(nextPageUrl, currentList)
                        }
                    )
                }
                is ArtworksState.Empty -> EmptyView()
                is ArtworksState.Error -> ErrorView() { viewModel.loadData() }
            }
        }
    }
}