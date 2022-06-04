package com.cybertaxi.mobile.data.network.auth

import com.cybertaxi.mobile.data.model.remote.RegisterResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAuthenticationApi {

    @POST("/user/authenticate")
    suspend fun auth(@Body username: String): Call<*>

    @POST("/user/login-code/refresh")
    suspend fun resendCode(): Call<*>

    @POST("/user/register")
    suspend fun registerUserByCode(code: String): Call<RegisterResult>

    @POST("/user/logout")
    suspend fun logout(): Call<*>
}