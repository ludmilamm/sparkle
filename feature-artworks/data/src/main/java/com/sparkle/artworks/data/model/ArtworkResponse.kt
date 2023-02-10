package com.sparkle.artworks.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ArtworkResponse(
    val id: Long = 0,
    val title: String? = null,
    @SerialName("artist_title")
    val artistTitle: String? = null,
    @SerialName("image_id")
    val imageId: String? = null,
    @SerialName("date_end")
    val date: Int? = 0,
    @SerialName("medium_display")
    val mediumDisplay: String? = null
)