package com.cybertaxi.mobile.data

interface UserPreferences {
    fun language(): String
    fun accessToken(): String
    fun deviceType(): String
    fun deviceId(): String
}