package com.cybertaxi.mobile.data.encryption

interface HashCipher {
    fun hash(message: String): String
    fun hash(message: ByteArray): String
}