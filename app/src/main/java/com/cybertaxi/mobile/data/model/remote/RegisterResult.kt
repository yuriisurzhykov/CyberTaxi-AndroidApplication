package com.cybertaxi.mobile.data.model.remote

data class RegisterResult(
    val userId: Long,
    val token: Token,
    val phoneNumber: String
)