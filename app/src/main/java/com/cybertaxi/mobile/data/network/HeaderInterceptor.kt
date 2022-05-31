package com.cybertaxi.mobile.data.network

import com.cybertaxi.mobile.data.UserPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject


open class HeaderInterceptor
@Inject
constructor(
    private val userPreferences: UserPreferences
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = updateBuilder(originalRequest.newBuilder()).build()
        return chain.proceed(newRequest)
    }

    protected open fun updateBuilder(builder: Request.Builder): Request.Builder {
        return builder
            .addHeader("device-type", userPreferences.deviceType())
            .addHeader("device-id", userPreferences.deviceId())
            .addHeader("access-token", userPreferences.accessToken())
            .addHeader("lang", userPreferences.locale().language)
    }
}