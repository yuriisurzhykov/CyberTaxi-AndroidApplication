package com.cybertaxi.mobile.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trip_variant")
data class TripVariantLocal(
    @PrimaryKey(autoGenerate = true)
    val tripVariantId: Int,
    val title: String,
    val language: String,
    val backgroundColor: Int,
    val iconUrl: String
)