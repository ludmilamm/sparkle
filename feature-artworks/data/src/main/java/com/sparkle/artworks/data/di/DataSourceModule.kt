package com.sparkle.artworks.data.di

import com.sparkle.artworks.data.remote.ArtworksRemoteDataSource
import com.sparkle.artworks.data.remote.ArtworksRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal interface DataSourceModule {

    @Binds
    fun provideArtworksRemoteDataSource(remoteDataSourceImpl: ArtworksRemoteDataSourceImpl): ArtworksRemoteDataSource
}