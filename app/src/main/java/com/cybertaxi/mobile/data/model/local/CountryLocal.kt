package com.cybertaxi.mobile.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class CountryLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val countryCode: String,
    val countryName: String,
    val locale: String,
    val phoneCode: String,
    val phoneLength: Int,
)