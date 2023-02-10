package com.sparkle.artworks.list

import com.sparkle.artworks.domain.GetArtworksUseCase
import com.sparkle.artworks.domain.repository.model.Artworks
import com.sparkle.core.test.CoroutineRule
import com.sparkle.core.test.TestAppDispatcher
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class ArtworksViewModelTest {

    @get:Rule
    val rule = CoroutineRule()

    private val getArtworksUseCase = mockk<GetArtworksUseCase>()

    private val sut = ArtworksViewModel(getArtworksUseCase, TestAppDispatcher())

    @Test
    fun `loadData - when list is empty`() = runTest() {
        every { getArtworksUseCase() } returns flowOf(Result.success(mockk(relaxed = true)))

        assertEquals(ArtworksState.Idle, sut.state.first())

        sut.loadData()

        advanceUntilIdle()

        assertEquals(ArtworksState.Empty, sut.state.first())
    }

    @Test
    fun `loadData - when list is loaded`() = runTest() {
        val artworks = mockk<Artworks>(relaxed = true) {
            every { artworks } returns listOf(mockk(relaxed = true))
        }

        every { getArtworksUseCase() } returns flowOf(Result.success(artworks))

        assertEquals(ArtworksState.Idle, sut.state.first())

        sut.loadData()

        advanceUntilIdle()

        assertTrue(sut.state.value is ArtworksState.Success.Loaded)
    }

    @Test
    fun `loadData - when returns an error`() = runTest() {
        every { getArtworksUseCase() } returns flowOf(Result.failure(IllegalArgumentException()))

        assertEquals(ArtworksState.Idle, sut.state.first())

        sut.loadData()

        advanceUntilIdle()

        assertEquals(ArtworksState.Error, sut.state.first())
    }
}