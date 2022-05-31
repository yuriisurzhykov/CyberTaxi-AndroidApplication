package com.cybertaxi.mobile.data.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class CarRemote(
    val id: Long,
    val carBrand: String,
    val carModel: String,
    val carNumber: String,
    val photos: List<String>
)