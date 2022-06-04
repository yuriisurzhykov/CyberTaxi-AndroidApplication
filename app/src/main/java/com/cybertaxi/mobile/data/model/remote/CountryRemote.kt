package com.cybertaxi.mobile.data.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class CountryRemote(
    val countryCode: String,
    val countryName: String,
    val locale: String,
    val phoneCode: String,
    val phoneLength: Int,
)