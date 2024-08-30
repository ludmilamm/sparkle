package com.sparkle.artworks.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.sparkle.artworks.domain.GetArtworksUseCase
import com.sparkle.artworks.toItemUiModel
import com.sparkle.core.utils.AppDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
internal class ArtworksViewModel @Inject constructor(
    private val getArtworksUseCase: GetArtworksUseCase,
    private val appDispatcher: AppDispatcher
) : ViewModel() {

    private val _state: MutableStateFlow<ArtworksState> = MutableStateFlow(ArtworksState.Idle)
    val state: StateFlow<ArtworksState> = _state

    fun loadData() = getArtworksUseCase()
        .map { pagingData ->
            pagingData.map { it.toItemUiModel() }
        }
        .flowOn(appDispatcher.dispatcher)
        .cachedIn(viewModelScope)
}