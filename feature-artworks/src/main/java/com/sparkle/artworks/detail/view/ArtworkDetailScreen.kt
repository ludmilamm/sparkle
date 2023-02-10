package com.sparkle.artworks.detail.view

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.sparkle.artworks.detail.ArtworkDetailState
import com.sparkle.artworks.detail.ArtworkDetailViewModel
import com.sparkle.core.ui.view.ErrorView
import com.sparkle.core.ui.view.InitLoad
import com.sparkle.core.ui.view.LoadingView

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun ArtworkDetailScreen(
    artworkId: Long,
    viewModel: ArtworkDetailViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    InitLoad {
        viewModel.loadData(artworkId)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        AnimatedContent(targetState = state) {
            when (state) {
                is ArtworkDetailState.Loading, is ArtworkDetailState.Idle -> LoadingView(Modifier.fillMaxSize())
                is ArtworkDetailState.Loaded -> ArtworkDetailView((state as ArtworkDetailState.Loaded).artwork)
                is ArtworkDetailState.Error -> ErrorView() { viewModel.loadData(artworkId) }
            }
        }
    }
}
