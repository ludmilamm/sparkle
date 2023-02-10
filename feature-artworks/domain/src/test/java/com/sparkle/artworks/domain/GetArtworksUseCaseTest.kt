package com.sparkle.artworks.domain

import com.sparkle.artworks.domain.repository.ArtworksRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
internal class GetArtworksUseCaseTest {

    private val mockRepository = mockk<ArtworksRepository>(relaxed = true)

    private val sut = GetArtworksUseCase(mockRepository)

    @Test
    fun `invoke - without next page url`() = runTest {
        sut.invoke().first()

        coVerify { mockRepository.getArtworks() }
    }

    @Test
    fun `invoke - with next page url`() = runTest {
        sut.invoke("next.com").first()

        coVerify { mockRepository.getArtworks("next.com") }
    }
}