package com.cybertaxi.mobile.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "trip_cancellation_reason")
data class TripCancellationReasonLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val value: String,
    val label: String,
    val lang: String
)