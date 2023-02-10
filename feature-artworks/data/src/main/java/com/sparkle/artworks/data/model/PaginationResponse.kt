package com.sparkle.artworks.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PaginationResponse(
    val total: Int = 0,
    @SerialName("total_pages")
    val totalPages: Int = 0,
    @SerialName("current_page")
    val currentPage: Int = 0,
    @SerialName("next_url")
    val nextUrl: String? = null
)