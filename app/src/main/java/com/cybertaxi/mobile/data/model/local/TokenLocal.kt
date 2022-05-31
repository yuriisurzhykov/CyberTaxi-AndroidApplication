package com.cybertaxi.mobile.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_tokens")
data class TokenLocal(
    @PrimaryKey
    val tokenValue: String,
    val lastUpdateTs: Long,
    val expireTs: Long
)