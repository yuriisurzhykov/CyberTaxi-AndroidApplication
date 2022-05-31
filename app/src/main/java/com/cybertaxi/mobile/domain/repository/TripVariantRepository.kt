package com.cybertaxi.mobile.domain.repository

import com.cybertaxi.core.Mapper
import com.cybertaxi.mobile.data.UserPreferences
import com.cybertaxi.mobile.data.cache.trips.TripVariantsDao
import com.cybertaxi.mobile.data.model.local.TripVariantLocal
import com.cybertaxi.mobile.data.model.remote.TripVariantRemote
import com.cybertaxi.mobile.data.network.trips.TripVariantsApi
import com.cybertaxi.mobile.domain.base.Repository
import com.cybertaxi.mobile.domain.model.TripVariant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TripVariantRepository
@Inject
constructor(
    private val tripVariantsDao: TripVariantsDao,
    private val tripVariantsApi: TripVariantsApi,
    private val userPreferences: UserPreferences,
    private val localTripVariantMapper: Mapper<TripVariantLocal, TripVariant>,
    private val remoteTripVariantMapper: Mapper<TripVariantRemote, TripVariant>
) : Repository<List<TripVariant>>() {

    override suspend fun fetchLocal(): Flow<List<TripVariant>> {
        return tripVariantsDao.fetchTripVariants(userPreferences.locale()).map { localList ->
            localList.map { localTripVariantMapper.map(it) }
        }
    }

    override suspend fun fetchRemote() = flow {
        val result = tripVariantsApi.fetchTripVariants(userPreferences.locale()).execute()
        if (result.isSuccessful) {
            emit(result.body().orEmpty().map { remoteTripVariantMapper.map(it) })
        } else {
            emit(emptyList())
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun storeRemoteData(data: List<TripVariant>) {
        data.forEach {
            tripVariantsDao.saveTripVariant(localTripVariantMapper.inverseMap(it))
        }
    }
}