package com.cybertaxi.mobile.di

import com.cybertaxi.core.Mapper
import com.cybertaxi.mobile.data.LocalePreferences
import com.cybertaxi.mobile.data.model.local.TripVariantLocal
import com.cybertaxi.mobile.data.model.remote.TripVariantRemote
import com.cybertaxi.mobile.domain.mappers.LocalTripVariantMapper
import com.cybertaxi.mobile.domain.mappers.RemoteTripVariantMapper
import com.cybertaxi.mobile.domain.model.TripVariant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MappersModule {

    @Provides
    @Singleton
    fun provideLocalTripVariantMapper(localePreferences: LocalePreferences): Mapper<TripVariantLocal, TripVariant> {
        return LocalTripVariantMapper(localePreferences)
    }

    @Provides
    @Singleton
    fun provideRemoteTripVariantMapper(localePreferences: LocalePreferences): Mapper<TripVariantRemote, TripVariant> {
        return RemoteTripVariantMapper(localePreferences)
    }
}