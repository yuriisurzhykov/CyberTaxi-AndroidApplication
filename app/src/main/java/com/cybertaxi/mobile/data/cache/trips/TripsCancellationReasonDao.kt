package com.cybertaxi.mobile.data.cache.trips

import androidx.room.*
import com.cybertaxi.mobile.data.model.local.TripCancellationReasonLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface TripsCancellationReasonDao {

    @Query("SELECT * FROM trip_cancellation_reason WHERE lang =:lang")
    suspend fun fetchTripVariants(lang: String): Flow<List<TripCancellationReasonLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTripVariant(tripVariantLocal: TripCancellationReasonLocal)

    @Delete
    suspend fun removeTripVariant(tripVariant: TripCancellationReasonLocal)

    @Query("DELETE FROM trip_variant")
    suspend fun clear()
}