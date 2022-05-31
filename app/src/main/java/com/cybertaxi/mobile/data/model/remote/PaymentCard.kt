package com.cybertaxi.mobile.data.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class PaymentCard(
    val pan: String,
    val holderName: String,
    val expireDate: String,
    val brand: String
)