package com.cybertaxi.mobile.data.model.remote

import com.cybertaxi.mobile.data.model.common.LatLng
import kotlinx.serialization.Serializable

@Serializable
data class OrderRemote(
    val orderReference: String,
    val driverRemote: DriverRemote,
    val destination: LatLng,
    val price: Double,
    val taxiType: TaxiTypeRemote,
    val tripType: TripVariantRemote,
    val currency: String,
    val state: OrderStateRemote,
    val payCard: PaymentCardRemote
)