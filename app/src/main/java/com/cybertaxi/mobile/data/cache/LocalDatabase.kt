package com.cybertaxi.mobile.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cybertaxi.mobile.data.model.local.TripVariantLocal

@Database(entities = [TripVariantLocal::class], version = 1, exportSchema = true)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun tripVariantsDao(): TripVariantsDao

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