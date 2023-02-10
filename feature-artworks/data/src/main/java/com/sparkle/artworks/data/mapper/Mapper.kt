package com.sparkle.artworks.data.mapper

import com.sparkle.artworks.data.model.ArtworkDetailResponse
import com.sparkle.artworks.data.model.ArtworkListResponse
import com.sparkle.artworks.data.model.ArtworkResponse
import com.sparkle.artworks.data.model.ConfigResponse
import com.sparkle.artworks.data.model.InfoResponse
import com.sparkle.artworks.data.model.PaginationResponse
import com.sparkle.artworks.domain.repository.model.Artwork
import com.sparkle.artworks.domain.repository.model.Artworks
import com.sparkle.artworks.domain.repository.model.Info
import com.sparkle.artworks.domain.repository.model.Pagination

const val IMAGE_URL_PARAMS = "full/843,/0/default.jpg"

internal fun ArtworkListResponse.toDomain() = Artworks(
    pagination = pagination.toDomain(),
    info = info.toDomain(),
    artworks = data
        ?.mapNotNull { runCatching { it.toDomain(config) }.getOrNull() } // filter inconsistent data
        ?.distinctBy { it.id }
        ?: error("invalid artwork payload")
)

internal fun PaginationResponse?.toDomain() = Pagination(
    total = this?.total ?: 0,
    totalPages = this?.totalPages ?: 0,
    currentPage = this?.currentPage ?: 0,
    nextUrl = this?.nextUrl
)

internal fun InfoResponse?.toDomain() = Info(
    licenseText = this?.licenseText.orEmpty(),
    licenseLinks = this?.licenseLinks.orEmpty()
)

internal fun ArtworkResponse?.toDomain(configResponse: ConfigResponse?) = Artwork(
    id = this?.id ?: error("invalid artwork id"),
    title = this.title ?: error("invalid artwork title"),
    artistTitle = this.artistTitle ?: error("invalid artwork artistTitle"),
    date = this.date ?: error("invalid artwork date"),
    description = this.mediumDisplay ?: error("invalid artwork description"),
    imageUrl = buildImageUrl(configResponse, this.imageId) ?: error("invalid artwork image")
)

internal fun ArtworkDetailResponse?.toDomain() = Artwork(
    id = this?.data?.id ?: error("invalid artwork id"),
    title = this.data.title ?: error("invalid artwork title"),
    artistTitle = this.data.artistTitle ?: error("invalid artwork artistTitle"),
    date = this.data.date ?: error("invalid artwork date"),
    description = this.data.mediumDisplay ?: error("invalid artwork description"),
    imageUrl = buildImageUrl(config, this.data.imageId) ?: error("invalid artwork image")
)

private fun buildImageUrl(configResponse: ConfigResponse?, imageId: String?): String? {
    return if (configResponse?.iiifUrl != null && imageId != null)
        configResponse.iiifUrl + "/$imageId/$IMAGE_URL_PARAMS"
    else null
}