package com.cybertaxi.mobile.data.model.remote

import com.cybertaxi.mobile.data.model.common.LatLng
import kotlinx.serialization.Serializable

@Serializable
data class Place(
    val placeName: String,
    val location: LatLng
)