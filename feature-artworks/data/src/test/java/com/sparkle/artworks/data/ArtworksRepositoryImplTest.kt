package com.sparkle.artworks.data

import com.sparkle.artworks.data.model.ArtworkResponse
import com.sparkle.artworks.data.model.ArtworkListResponse
import com.sparkle.artworks.data.model.ConfigResponse
import com.sparkle.artworks.data.model.InfoResponse
import com.sparkle.artworks.data.model.PaginationResponse
import com.sparkle.artworks.data.remote.ArtworksRemoteDataSource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
internal class ArtworksRepositoryImplTest {

    private val mockRemoteDataSource = mockk<ArtworksRemoteDataSource>()

    private val sut = ArtworksRepositoryImpl(mockRemoteDataSource)

    @Test
    fun `getArtworks success - without next page url`() = runTest {
        val fakeResponse = ArtworkListResponse(
            pagination = PaginationResponse(
                total = 20,
                totalPages = 2,
                currentPage = 1,
                nextUrl = "next.com"
            ),
            info = InfoResponse(
                licenseText = "license",
                licenseLinks = listOf("link1", "link2")
            ),
            config = ConfigResponse(iiifUrl = "iiif.com"),
            data = listOf(
                ArtworkResponse(
                    id = 10,
                    title = "Sunflower",
                    artistTitle = "Van Gogh",
                    imageId = "123"
                )
            )
        )

        coEvery { mockRemoteDataSource.getArtworks() } returns Result.success(fakeResponse)

        val result = sut.getArtworks()

        coVerify { mockRemoteDataSource.getArtworks() }
        assertTrue(result.isSuccess)
    }

    @Test
    fun `getArtworks success - with next page url`() = runTest {
        val fakeResponse = ArtworkListResponse(
            pagination = PaginationResponse(
                total = 20,
                totalPages = 2,
                currentPage = 1,
                nextUrl = "next.com"
            ),
            info = InfoResponse(
                licenseText = "license",
                licenseLinks = listOf("link1", "link2")
            ),
            config = ConfigResponse(iiifUrl = "iiif.com"),
            data = listOf(
                ArtworkResponse(
                    id = 10,
                    title = "Sunflower",
                    artistTitle = "Van Gogh",
                    imageId = "123"
                )
            )
        )

        coEvery { mockRemoteDataSource.getArtworks("next.com") } returns Result.success(fakeResponse)

        val result = sut.getArtworks("next.com")

        coVerify { mockRemoteDataSource.getArtworks("next.com") }
        assertTrue(result.isSuccess)
    }

    @Test
    fun `getArtworks failure - without next page url`() = runTest {
        val fakeResponse = ArtworkListResponse(
            pagination = null,
            info = null,
            config = null,
            data = null
        )

        coEvery { mockRemoteDataSource.getArtworks() } returns Result.success(fakeResponse)

        val result = sut.getArtworks()

        coVerify { mockRemoteDataSource.getArtworks() }
        assertTrue(result.isFailure)
    }

    @Test
    fun `getArtworks failure - with next page url`() = runTest {
        val fakeResponse = ArtworkListResponse(
            pagination = null,
            info = null,
            config = null,
            data = null
        )

        coEvery { mockRemoteDataSource.getArtworks("next.com") } returns Result.success(fakeResponse)

        val result = sut.getArtworks("next.com")

        coVerify { mockRemoteDataSource.getArtworks("next.com") }
        assertTrue(result.isFailure)
    }
}