package com.cybertaxi.mobile.data.cache.countries

import androidx.room.*
import com.cybertaxi.mobile.data.model.local.CountryLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface CountriesDao {

    @Query("SELECT * FROM country")
    suspend fun countries(): Flow<List<CountryLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(countryLocal: CountryLocal)

    @Delete
    suspend fun delete(countryLocal: CountryLocal)

    @Query("DELETE FROM country")
    suspend fun clear()
}