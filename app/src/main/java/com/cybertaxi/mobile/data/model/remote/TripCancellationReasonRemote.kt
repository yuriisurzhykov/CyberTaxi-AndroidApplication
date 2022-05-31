package com.cybertaxi.mobile.data.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class TripCancellationReasonRemote(
    val id: Int,
    val value: String,
    val label: String,
    val lang: String
)