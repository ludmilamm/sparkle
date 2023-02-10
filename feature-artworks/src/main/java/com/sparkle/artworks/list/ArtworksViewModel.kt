package com.sparkle.artworks.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sparkle.artworks.domain.GetArtworksUseCase
import com.sparkle.artworks.list.model.ArtworkItemUiModel
import com.sparkle.artworks.toItemUiModel
import com.sparkle.core.utils.AppDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
internal class ArtworksViewModel @Inject constructor(
    private val getArtworksUseCase: GetArtworksUseCase,
    private val appDispatcher: AppDispatcher
) : ViewModel() {

    private val _state: MutableStateFlow<ArtworksState> = MutableStateFlow(ArtworksState.Idle)
    val state: StateFlow<ArtworksState> = _state

    fun loadData() {
        appendArtworks()
            .onStart { _state.value = ArtworksState.Loading }
            .flowOn(appDispatcher.dispatcher)
            .launchIn(viewModelScope)
    }

    fun loadNextPage(url: String?, currentList: List<ArtworkItemUiModel>) {
        if (url == null) return

        appendArtworks(url, currentList)
            .onStart { _state.value = ArtworksState.Success.LoadingMore }
            .flowOn(appDispatcher.dispatcher)
            .launchIn(viewModelScope)
    }

    private fun appendArtworks(
        url: String? = null,
        currentList: List<ArtworkItemUiModel> = emptyList()
    ) = getArtworksUseCase(url)
        .catch { _state.value = ArtworksState.Error }
        .onEach { result ->
            result.onFailure {
                _state.value = ArtworksState.Error
            }.onSuccess { data ->
                if (data.artworks.isEmpty()) {
                    _state.value = ArtworksState.Empty
                } else {
                    _state.value = ArtworksState.Success.Loaded(
                        artworks = currentList + data.artworks.map { it.toItemUiModel() },
                        nextPageUrl = data.pagination.nextUrl
                    )
                }
            }
        }
}