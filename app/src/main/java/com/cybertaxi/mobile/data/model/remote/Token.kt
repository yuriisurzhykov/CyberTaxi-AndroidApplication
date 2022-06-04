package com.cybertaxi.mobile.data.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class Token(
    val tokenValue: String,
    val lastUpdateTs: Long,
    val expireTs: Long,
    val userId: Long
)