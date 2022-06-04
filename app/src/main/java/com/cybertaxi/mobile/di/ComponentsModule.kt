package com.cybertaxi.mobile.di

import com.cybertaxi.core.coroutines.Dispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ComponentsModule {

    @Provides
    @Singleton
    fun provideDispatchers(): Dispatchers = Dispatchers.Base()
}