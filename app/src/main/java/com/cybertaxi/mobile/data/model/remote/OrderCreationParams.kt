package com.cybertaxi.mobile.data.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class OrderCreationParams(
    val taxiTypeRemote: TaxiTypeRemote,
    val tripType: TripVariantRemote,
    val paymentMethod: PaymentCardRemote,
    val destination: Place,
    val departure: Place
)