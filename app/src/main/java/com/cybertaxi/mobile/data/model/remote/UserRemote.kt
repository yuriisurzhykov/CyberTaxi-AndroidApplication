package com.cybertaxi.mobile.data.model.remote

data class UserRemote(
    val remoteId: Long,
    val orders: List<OrderRemote>,
    val phoneNumber: String,
    val birthday: String,
    val cards: List<PayCardRemote>,
    val firstName: String,
    val secondName: String,
    val preferredLanguage: String,
    val preferredCardPan: String
)