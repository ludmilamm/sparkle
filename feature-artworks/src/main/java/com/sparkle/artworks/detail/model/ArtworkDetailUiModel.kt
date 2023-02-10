package com.sparkle.artworks.detail.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class ArtworkDetailUiModel(
    val id: Long,
    val title: String,
    val artistTitle: String,
    val imageUrl: String,
    val date: Int,
    val description: String
) : Parcelable