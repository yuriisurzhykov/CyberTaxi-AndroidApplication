package com.cybertaxi.mobile.data.encryption

import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject

class SHA256HashCipher @Inject constructor() : HashCipher {
    override fun hash(message: String): String {
        return hash(message.toByteArray())
    }

    override fun hash(message: ByteArray): String {
        val messageDigest = MessageDigest.getInstance("SHA-256")
        messageDigest.update(message, 0, message.size)
        return BigInteger(1, messageDigest.digest()).toString(16)
    }
}