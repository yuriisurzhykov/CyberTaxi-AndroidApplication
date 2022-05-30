package com.cybertaxi.mobile.data.network

import com.cybertaxi.mobile.data.UserPreferences
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class HeaderInterceptor
@Inject
constructor(
    private val userPreferences: UserPreferences
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .addHeader("device-type", userPreferences.deviceType())
            .addHeader("device-id", userPreferences.deviceId())
            .addHeader("access-token", userPreferences.accessToken())
            .addHeader("language", userPreferences.language())
            .build()
        return chain.proceed(newRequest)
    }
}