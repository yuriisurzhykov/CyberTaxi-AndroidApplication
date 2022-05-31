package com.cybertaxi.mobile.di

import com.cybertaxi.core.Mapper
import com.cybertaxi.mobile.data.UserPreferences
import com.cybertaxi.mobile.data.cache.trips.TripVariantsDao
import com.cybertaxi.mobile.data.model.local.TripVariantLocal
import com.cybertaxi.mobile.data.model.remote.TripVariantRemote
import com.cybertaxi.mobile.data.network.trips.TripVariantsApi
import com.cybertaxi.mobile.domain.base.Repository
import com.cybertaxi.mobile.domain.model.TripVariant
import com.cybertaxi.mobile.domain.repository.TripVariantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTripVariantRepository(
        tripVariantsDao: TripVariantsDao,
        tripVariantsApi: TripVariantsApi,
        userPreferences: UserPreferences,
        localTripVariantMapper: Mapper<TripVariantLocal, TripVariant>,
        remoteTripVariantMapper: Mapper<TripVariantRemote, TripVariant>
    ): Repository<List<TripVariant>> {
        return TripVariantRepository(
            tripVariantsDao, tripVariantsApi, userPreferences, localTripVariantMapper, remoteTripVariantMapper
        )
    }
}