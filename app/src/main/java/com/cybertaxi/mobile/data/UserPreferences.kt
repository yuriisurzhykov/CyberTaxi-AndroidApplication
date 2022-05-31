package com.cybertaxi.mobile.data

import java.util.*

interface LocalePreferences {
    fun locale(): Locale
}

interface TokenPreferences {
    fun accessToken(): String
}

interface DevicePreferences {
    fun deviceId(): String
    fun deviceType(): String
}

interface UserPreferences : DevicePreferences, TokenPreferences, LocalePreferences