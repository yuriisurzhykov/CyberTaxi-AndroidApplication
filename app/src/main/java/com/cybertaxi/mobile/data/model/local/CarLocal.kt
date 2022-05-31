package com.cybertaxi.mobile.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car")
data class CarLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val remoteId: Long,
    val carBrand: String,
    val carModel: String,
    val carNumber: String,
    val photos: List<String>
)