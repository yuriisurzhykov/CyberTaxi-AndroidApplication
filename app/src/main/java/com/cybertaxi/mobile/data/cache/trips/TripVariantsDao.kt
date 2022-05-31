package com.cybertaxi.mobile.data.cache.trips

import androidx.room.*
import com.cybertaxi.mobile.data.model.local.TripVariantLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface TripVariantsDao {

    @Query("SELECT * FROM trip_variant WHERE language =:lang")
    suspend fun fetchTripVariants(lang: String): Flow<List<TripVariantLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTripVariant(tripVariantLocal: TripVariantLocal)

    @Delete
    suspend fun removeTripVariant(tripVariant: TripVariantLocal)

    @Query("DELETE FROM trip_variant")
    suspend fun clear()
}