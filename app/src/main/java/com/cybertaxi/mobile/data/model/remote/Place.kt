package com.cybertaxi.mobile.data.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class Place(
    val placeName: String,
    val location: LatLng
)