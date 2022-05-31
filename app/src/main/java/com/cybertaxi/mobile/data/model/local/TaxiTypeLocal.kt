package com.cybertaxi.mobile.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "taxi_type")
data class TaxiTypeLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val lang: String,
    val nameLocale: String,
    val price: Double,
    val iconUrl: String
)