package com.cybertaxi.mobile.data.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class OrderStateRemote(
    val stateType: String,
    val stateName: String,
    val lang: String,
)