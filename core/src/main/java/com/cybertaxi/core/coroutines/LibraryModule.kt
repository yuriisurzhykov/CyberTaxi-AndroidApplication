package com.cybertaxi.core.coroutines

import dagger.Binds
import dagger.Module

@Module
abstract class LibraryModule {

    @Binds
    abstract fun provideDispatchers(dispatchers: Dispatchers.Base): Dispatchers
}