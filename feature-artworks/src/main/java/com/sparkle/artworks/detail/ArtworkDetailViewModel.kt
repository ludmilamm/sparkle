package com.sparkle.artworks.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sparkle.artworks.domain.GetArtworkUseCase
import com.sparkle.artworks.toDetailUiModel
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
internal class ArtworkDetailViewModel @Inject constructor(
    private val getArtworkUseCase: GetArtworkUseCase,
    private val appDispatcher: AppDispatcher
) : ViewModel() {

    private val _state: MutableStateFlow<ArtworkDetailState> = MutableStateFlow(ArtworkDetailState.Idle)
    val state: StateFlow<ArtworkDetailState> = _state

    fun loadData(artworkId: Long) {
        getArtworkUseCase(artworkId)
            .onStart { _state.value = ArtworkDetailState.Loading }
            .catch { _state.value = ArtworkDetailState.Error }
            .onEach { result ->
                result.onSuccess {
                    _state.value = ArtworkDetailState.Loaded(it.toDetailUiModel())
                }.onFailure {
                    _state.value = ArtworkDetailState.Error
                }
            }
            .flowOn(appDispatcher.dispatcher)
            .launchIn(viewModelScope)
    }
}