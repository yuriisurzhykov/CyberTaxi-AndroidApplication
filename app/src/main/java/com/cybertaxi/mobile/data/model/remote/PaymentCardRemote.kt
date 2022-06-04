package com.cybertaxi.mobile.data.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class PaymentCardRemote(
    val remoteId: String,
    val cardPan: String,
    val cardExpiry: String,
    val cardholderName: String,
    val cardBrand: String,
    val cardBrandIconUrl: String
)