package com.cybertaxi.mobile.data.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class DriverAcceptParams(
    val orderReference: String,
    val userId: Long,
    val driverId: Long
)