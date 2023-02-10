package com.sparkle.artworks.data.model

import kotlinx.serialization.Serializable

@Serializable
internal data class ArtworkDetailResponse(
    val info: InfoResponse? = null,
    val config: ConfigResponse? = null,
    val data: ArtworkResponse? = null
)