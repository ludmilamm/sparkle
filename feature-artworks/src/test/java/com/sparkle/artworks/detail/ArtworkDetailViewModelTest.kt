package com.sparkle.artworks.detail

import com.sparkle.artworks.domain.GetArtworkUseCase
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
internal class ArtworkDetailViewModelTest {

    @get:Rule
    val rule = CoroutineRule()

    private val getArtworkUseCase = mockk<GetArtworkUseCase>()

    private val sut = ArtworkDetailViewModel(getArtworkUseCase, TestAppDispatcher())

    @Test
    fun `loadData - when is loaded`() = runTest {
        every { getArtworkUseCase(any()) } returns flowOf(Result.success(mockk(relaxed = true)))

        assertEquals(ArtworkDetailState.Idle, sut.state.first())

        sut.loadData(123)

        advanceUntilIdle()

        assertTrue(sut.state.first() is ArtworkDetailState.Loaded)
    }

    @Test
    fun `loadData - when is error`() = runTest {
        every { getArtworkUseCase(any()) } returns flowOf(Result.failure(IllegalArgumentException()))

        assertEquals(ArtworkDetailState.Idle, sut.state.first())

        sut.loadData(123)

        advanceUntilIdle()

        assertEquals(ArtworkDetailState.Error, sut.state.first())
    }
}