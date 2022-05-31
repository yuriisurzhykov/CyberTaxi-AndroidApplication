package com.cybertaxi.mobile.data.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class PayCardRemote(
    val remoteId: String,
    val cardPan: String,
    val cardExpiry: String,
    val cardholderName: String,
    val cardBrand: String,
    val cardBrandIconUrl: String
)