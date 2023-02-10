package com.sparkle.artworks.domain.repository.model

data class Artworks(
    val pagination: Pagination,
    val info: Info,
    val artworks: List<Artwork>
)