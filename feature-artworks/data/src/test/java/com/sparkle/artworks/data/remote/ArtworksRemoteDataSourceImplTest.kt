package com.sparkle.artworks.data.remote

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
internal class ArtworksRemoteDataSourceImplTest {

    private val mockArtworksApi = mockk<ArtworksApi>()

    private val sut = ArtworksRemoteDataSourceImpl(mockArtworksApi)

    @Test
    fun `getArtworks success - without next page url`() = runTest {
        coEvery { mockArtworksApi.getArtworks(any(), any()) } returns mockk()

        val result = sut.getArtworks()

        coVerify { mockArtworksApi.getArtworks("id,title,artist_title,image_id,date_end,medium_display", 100) }
        assertTrue(result.isSuccess)
    }

    @Test
    fun `getArtworks success - with next page url`() = runTest {
        coEvery { mockArtworksApi.getArtworks(any(), any(), any()) } returns mockk()

        val result = sut.getArtworks("url")

        coVerify { mockArtworksApi.getArtworks("url", "id,title,artist_title,image_id,date_end,medium_display", 100) }
        assertTrue(result.isSuccess)
    }

    @Test
    fun `getArtworks failure - without next page url`() = runTest {
        coEvery { mockArtworksApi.getArtworks(any(), any()) } answers { throw IllegalArgumentException() }

        val result = sut.getArtworks()

        assertTrue(result.isFailure)
    }

    @Test
    fun `getArtworks failure - with next page url`() = runTest {
        coEvery { mockArtworksApi.getArtworks(any(), any()) } answers { throw IllegalArgumentException() }

        val result = sut.getArtworks("url")

        assertTrue(result.isFailure)
    }
}