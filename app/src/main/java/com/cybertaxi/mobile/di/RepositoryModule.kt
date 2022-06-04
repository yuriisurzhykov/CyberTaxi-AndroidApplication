package com.cybertaxi.mobile.di

import com.cybertaxi.core.Mapper
import com.cybertaxi.mobile.data.UserPreferences
import com.cybertaxi.mobile.data.cache.countries.CountriesDao
import com.cybertaxi.mobile.data.cache.trips.TripVariantsDao
import com.cybertaxi.mobile.data.model.local.CountryLocal
import com.cybertaxi.mobile.data.model.local.TripVariantLocal
import com.cybertaxi.mobile.data.model.remote.CountryRemote
import com.cybertaxi.mobile.data.model.remote.TripVariantRemote
import com.cybertaxi.mobile.data.network.countries.CountriesApi
import com.cybertaxi.mobile.data.network.trips.TripsVariantsApi
import com.cybertaxi.mobile.domain.base.Repository
import com.cybertaxi.mobile.domain.model.Country
import com.cybertaxi.mobile.domain.model.TripVariant
import com.cybertaxi.mobile.domain.repository.CountriesRepository
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
        tripsVariantsApi: TripsVariantsApi,
        userPreferences: UserPreferences,
        localTripVariantMapper: Mapper<TripVariantLocal, TripVariant>,
        remoteTripVariantMapper: Mapper<TripVariantRemote, TripVariant>
    ): Repository<List<TripVariant>> {
        return TripVariantRepository(
            tripVariantsDao, tripsVariantsApi, userPreferences, localTripVariantMapper, remoteTripVariantMapper
        )
    }

    @Provides
    @Singleton
    fun provideCountriesRepository(
        countriesDao: CountriesDao,
        countriesApi: CountriesApi,
        localCountriesMapper: Mapper<CountryLocal, Country>,
        remoteCountriesMapper: Mapper<CountryRemote, Country>
    ): Repository<List<Country>> {
        return CountriesRepository(
            countriesApi, countriesDao, localCountriesMapper, remoteCountriesMapper
        )
    }


}