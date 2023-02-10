package com.sparkle.artworks.data.di

import com.sparkle.artworks.data.remote.ArtworksApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
internal object ApiModule {

    @Provides
    fun provideArtworksApi(retrofit: Retrofit) = retrofit.create(ArtworksApi::class.java)
}