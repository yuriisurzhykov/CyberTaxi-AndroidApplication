package com.cybertaxi.mobile.domain.model

data class Country(
    val countryName: String,
    val countryCode: String,
    val phoneCode: String,
    val phoneLength: Int,
    val locale: String
)