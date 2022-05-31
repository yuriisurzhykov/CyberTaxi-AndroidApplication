package com.cybertaxi.mobile.data.cache.user

import com.cybertaxi.mobile.data.DevicePreferences
import com.cybertaxi.mobile.data.LocalePreferences
import com.cybertaxi.mobile.data.TokenPreferences
import com.cybertaxi.mobile.data.UserPreferences
import javax.inject.Inject

class UserPreferencesStorage
@Inject
constructor(
    private val devicePreferences: DevicePreferences,
    private val languagePreferences: LocalePreferences,
    private val tokenPreferences: TokenPreferences
) : UserPreferences {

    override fun locale() = languagePreferences.locale()

    override fun accessToken() = tokenPreferences.accessToken()

    override fun deviceId() = devicePreferences.deviceId()

    override fun deviceType() = devicePreferences.deviceType()
}