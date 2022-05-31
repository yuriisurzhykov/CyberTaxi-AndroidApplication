package com.cybertaxi.mobile.data.encryption

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.security.interfaces.RSAPublicKey

object KeyHelper {

    private const val KEY_STORE_NAME = "store.bks"

    private const val ALGORITHM = KeyProperties.KEY_ALGORITHM_RSA + "/" +
            KeyProperties.BLOCK_MODE_ECB + "/" +
            KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1

    private const val PROVIDER = "AndroidKeyStore"

    val keyHolder by lazy { KeyStore.getInstance(PROVIDER) }

    @JvmStatic
    fun createRsaKey(): RSAPublicKey {
        val generator = KeyPairGenerator.getInstance(ALGORITHM, PROVIDER)
        val params = KeyGenParameterSpec.Builder(
            KEY_STORE_NAME, KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
            .setKeySize(2048)
            .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)
            .build()
        generator.initialize(params)
        return generator.generateKeyPair().public as RSAPublicKey
    }

}