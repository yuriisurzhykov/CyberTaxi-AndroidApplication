package com.cybertaxi.mobile.data.cache.user

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import com.cybertaxi.mobile.data.DevicePreferences
import com.cybertaxi.mobile.data.encryption.HashCipher
import javax.inject.Inject

open class DevicePreferencesStorage
@Inject
constructor(
    private val context: Context,
    private val hashCipher: HashCipher
) : DevicePreferences {

    @SuppressLint("HardwareIds")
    override fun deviceId(): String {
        val contentResolver = context.applicationContext.contentResolver
        return hashCipher.hash(Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID))
    }

    override fun deviceType() = "android"
}