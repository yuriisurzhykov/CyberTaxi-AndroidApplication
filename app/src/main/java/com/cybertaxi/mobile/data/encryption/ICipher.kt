package com.cybertaxi.mobile.data.encryption

interface ICipher<T> {
    fun encrypt(entity: T): String
    fun decrypt(message: String): T
}