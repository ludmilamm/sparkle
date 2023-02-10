package com.sparkle.artworks.data.di

import com.sparkle.artworks.data.ArtworksRepositoryImpl
import com.sparkle.artworks.domain.repository.ArtworksRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal interface RepositoryModule {

    @Binds
    fun provideArtworksRepository(artworksRepositoryImpl: ArtworksRepositoryImpl): ArtworksRepository
}