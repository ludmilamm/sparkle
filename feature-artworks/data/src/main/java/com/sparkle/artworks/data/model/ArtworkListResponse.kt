package com.sparkle.artworks.data.model

import kotlinx.serialization.Serializable

@Serializable
internal data class ArtworkListResponse(
    val pagination: PaginationResponse? = null,
    val info: InfoResponse? = null,
    val config: ConfigResponse? = null,
    val data: List<ArtworkResponse>? = null
)