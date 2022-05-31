package com.cybertaxi.mobile.di

import android.content.Context
import com.cybertaxi.mobile.data.cache.LocalDatabase
import com.cybertaxi.mobile.data.cache.auth.UserTokensDao
import com.cybertaxi.mobile.data.cache.trips.TripVariantsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideLocaleDatabase(@ApplicationContext context: Context): LocalDatabase {
        return LocalDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideTripVariantsDao(database: LocalDatabase): TripVariantsDao {
        return database.tripVariantsDao()
    }

    @Provides
    @Singleton
    fun provideUserTokenDao(database: LocalDatabase): UserTokensDao {
        return database.tokensDao()
    }
}