package com.carlosgub.redditapp.di

import com.carlosgub.redditapp.features.top.data.datasource.TopDataStore
import com.carlosgub.redditapp.features.top.data.repository.TopPostRepositoryImpl
import com.carlosgub.redditapp.features.top.domain.repository.TopPostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideTopPostRepository(): TopPostRepository = TopPostRepositoryImpl(TopDataStore())
}