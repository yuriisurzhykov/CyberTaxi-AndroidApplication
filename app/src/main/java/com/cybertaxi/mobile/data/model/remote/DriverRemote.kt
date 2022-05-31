package com.cybertaxi.mobile.data.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class DriverRemote(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val rating: Float,
    val driverProfileIconUrl: String,
    val number: String,
    val car: CarRemote
)