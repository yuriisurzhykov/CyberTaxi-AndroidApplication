package com.cybertaxi.mobile.data.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class TaxiTypeRemote(
    val lang: String,
    val nameLocale: String,
    val typeValue: String,
    val price: Double,
    val iconUrl: String
)