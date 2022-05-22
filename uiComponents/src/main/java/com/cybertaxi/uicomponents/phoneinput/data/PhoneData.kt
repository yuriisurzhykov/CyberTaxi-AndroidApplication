package com.cybertaxi.uicomponents.phoneinput.data

data class PhoneData(
    val code: String,
    val countryName: String,
    val phoneCode: String,
    val flagImage: String,
    val minLength: Int = phoneCode.length + 1,
    val maxLength: Int = 0
)