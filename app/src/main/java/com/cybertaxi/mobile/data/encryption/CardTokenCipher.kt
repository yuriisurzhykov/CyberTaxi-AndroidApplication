package com.cybertaxi.mobile.data.encryption

import com.cybertaxi.mobile.data.encryption.KeyHelper.createRsaKey
import com.cybertaxi.mobile.data.encryption.ICipher
import com.cybertaxi.mobile.data.model.remote.PaymentCard
import com.cybertaxi.mobile.data.encryption.CardTokenCipher
import com.cybertaxi.mobile.data.encryption.KeyHelper
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okio.internal.commonToUtf8String
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher
import javax.crypto.NoSuchPaddingException

class CardTokenCipher : ICipher<PaymentCard> {

    override fun decrypt(token: String): PaymentCard {
        return Json.decodeFromString(decryptCipher().doFinal(token.toByteArray()).commonToUtf8String())
    }

    override fun encrypt(entity: PaymentCard): String {
        return encryptCipher().doFinal(Json.encodeToString(entity).toByteArray()).commonToUtf8String()
    }

    @Throws(NoSuchPaddingException::class, NoSuchAlgorithmException::class, InvalidKeyException::class)
    private fun encryptCipher(): Cipher {
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.ENCRYPT_MODE, createRsaKey())
        return cipher
    }

    @Throws(NoSuchPaddingException::class, NoSuchAlgorithmException::class, InvalidKeyException::class)
    private fun decryptCipher(): Cipher {
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.DECRYPT_MODE, createRsaKey())
        return cipher
    }

    companion object {
        private const val ALGORITHM = "RSA/ECB/PKCS1Padding"
    }
}