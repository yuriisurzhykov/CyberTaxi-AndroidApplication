package com.cybertaxi.mobile.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "driver")
data class DriverLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val remoteId: Long,
    val firstName: String,
    val lastName: String,
    val driverProfileIconUrl: String,
    val phoneNumber: String,
    val rating: Float
)