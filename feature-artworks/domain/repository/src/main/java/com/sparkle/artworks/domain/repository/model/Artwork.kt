package com.sparkle.artworks.domain.repository.model

data class Artwork(
    val id: Long,
    val title: String,
    val artistTitle: String,
    val imageUrl: String,
    val date: Int,
    val description: String
)