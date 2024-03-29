package com.cybertaxi.mobile.data.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class TripVariantRemote(
    val title: String,
    val lang: String,
    val variantValue: String,
    val backgroundColor: Int,
    val iconUrl: String
)