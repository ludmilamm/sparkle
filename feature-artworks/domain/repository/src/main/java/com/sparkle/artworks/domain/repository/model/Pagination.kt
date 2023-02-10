package com.sparkle.artworks.domain.repository.model

data class Pagination(
    val total: Int,
    val totalPages: Int,
    val currentPage: Int,
    val nextUrl: String?
)