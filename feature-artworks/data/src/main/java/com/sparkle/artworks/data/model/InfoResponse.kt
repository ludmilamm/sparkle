package com.sparkle.artworks.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class InfoResponse(
    @SerialName("license_text")
    val licenseText: String? = null,
    @SerialName("license_links")
    val licenseLinks: List<String>? = null
)