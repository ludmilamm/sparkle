package com.sparkle.core.utils.di

import com.sparkle.core.utils.AppDispatcher
import com.sparkle.core.utils.AppDispatcherImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal interface UtilsModule {

    @Binds
    fun provideAppDispatcher(appDispatcherImpl: AppDispatcherImpl): AppDispatcher
}