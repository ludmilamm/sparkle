package com.sparkle.artworks.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ConfigResponse(
    @SerialName("iiif_url")
    val iiifUrl: String? = null
)