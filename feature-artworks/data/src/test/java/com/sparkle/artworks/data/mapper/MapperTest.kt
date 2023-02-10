package com.sparkle.artworks.data.mapper

import com.sparkle.artworks.data.model.ArtworkListResponse
import com.sparkle.artworks.data.model.ArtworkResponse
import com.sparkle.artworks.data.model.ConfigResponse
import com.sparkle.artworks.data.model.InfoResponse
import com.sparkle.artworks.data.model.PaginationResponse
import com.sparkle.artworks.domain.repository.model.Artwork
import com.sparkle.artworks.domain.repository.model.Artworks
import com.sparkle.artworks.domain.repository.model.Info
import com.sparkle.artworks.domain.repository.model.Pagination
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class MapperTest {

    @Test
    fun `toDomain - when response is valid`() {
        val given = ArtworkListResponse(
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
                    imageId = "123",
                    date = 1995,
                    mediumDisplay = "description"
                )
            )
        )

        val expected = Artworks(
            pagination = Pagination(
                total = 20,
                totalPages = 2,
                currentPage = 1,
                nextUrl = "next.com"
            ),
            info = Info(
                licenseText = "license",
                licenseLinks = listOf("link1", "link2")
            ),
            artworks = listOf(
                Artwork(
                    id = 10,
                    title = "Sunflower",
                    artistTitle = "Van Gogh",
                    imageUrl = "iiif.com/123/full/843,/0/default.jpg",
                    date = 1995,
                    description = "description"
                )
            )
        )

        val result = given.toDomain()

        assertEquals(expected, result)
    }

    @Test
    fun `toDomain - when response is not valid`() {
        val given = ArtworkListResponse(
            pagination = null,
            info = null,
            config = null,
            data = null
        )

        val result = runCatching { given.toDomain() }.isFailure

        assertTrue(result)
    }

    @Test
    fun `toDomain - when data are not valid`() {
        val given = ArtworkListResponse(
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
                    imageId = "123",
                    date = 1995,
                    mediumDisplay = "description"
                ),
                ArtworkResponse(),
                ArtworkResponse(
                    id = 20,
                    title = "Sunflower",
                    artistTitle = "Van Gogh",
                    imageId = null,
                    date = 1995,
                    mediumDisplay = "description"
                ),
                ArtworkResponse(
                    id = 10,
                    title = "Sunflower",
                    artistTitle = "Van Gogh",
                    imageId = "123",
                    date = 1995,
                    mediumDisplay = "description"
                )
            )
        )

        val expected = Artworks(
            pagination = Pagination(
                total = 20,
                totalPages = 2,
                currentPage = 1,
                nextUrl = "next.com"
            ),
            info = Info(
                licenseText = "license",
                licenseLinks = listOf("link1", "link2")
            ),
            artworks = listOf(
                Artwork(
                    id = 10,
                    title = "Sunflower",
                    artistTitle = "Van Gogh",
                    imageUrl = "iiif.com/123/full/843,/0/default.jpg",
                    date = 1995,
                    description = "description"
                )
            )
        )

        val result = given.toDomain()

        assertEquals(expected, result)
    }
}