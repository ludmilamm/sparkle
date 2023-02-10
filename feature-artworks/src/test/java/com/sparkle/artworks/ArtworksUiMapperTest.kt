package com.sparkle.artworks

import com.sparkle.artworks.detail.model.ArtworkDetailUiModel
import com.sparkle.artworks.domain.repository.model.Artwork
import com.sparkle.artworks.list.model.ArtworkItemUiModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class ArtworksUiMapperTest {

    @Test
    fun toDetailUiModel() {
        val given = Artwork(
            id = 10,
            title = "title",
            artistTitle = "artist",
            imageUrl = "url.com",
            date = 1234,
            description = "description"
        )

        val expected = ArtworkDetailUiModel(
            id = 10,
            title = "title",
            artistTitle = "artist",
            imageUrl = "url.com",
            date = 1234,
            description = "description"
        )

        val result = given.toDetailUiModel()

        assertEquals(expected, result)
    }

    @Test
    fun toItemUiModel() {
        val given = Artwork(
            id = 10,
            title = "title",
            artistTitle = "artist",
            imageUrl = "url.com",
            date = 1234,
            description = "description"
        )

        val expected = ArtworkItemUiModel(
            id = 10,
            imageUrl = "url.com"
        )

        val result = given.toItemUiModel()

        assertEquals(expected, result)
    }
}