package com.cybertaxi.mobile.data.cache

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cybertaxi.mobile.data.cache.auth.UserTokensDao
import com.cybertaxi.mobile.data.cache.countries.CountriesDao
import com.cybertaxi.mobile.data.cache.trips.TripVariantsDao
import com.cybertaxi.mobile.data.cache.trips.TripsCancellationReasonDao
import com.cybertaxi.mobile.data.model.local.*

@Database(
    entities = [
        TripVariantLocal::class,
        CarLocal::class,
        DriverLocal::class,
        TokenLocal::class,
        TaxiTypeLocal::class
    ],
    version = 1,
    exportSchema = true,
    autoMigrations = [AutoMigration(from = 1, to = 2)]
)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun tripVariantsDao(): TripVariantsDao

    abstract fun tokensDao(): UserTokensDao

    abstract fun countriesDao(): CountriesDao

    abstract fun tripCancellationReasonDao(): TripsCancellationReasonDao

    companion object {
        @Volatile
        private var INSTANCE: LocalDatabase? = null

        fun getInstance(context: Context): LocalDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance =
                    Room.databaseBuilder(context, LocalDatabase::class.java, "local_database").build()
                INSTANCE = instance
                instance
            }
        }
    }
}