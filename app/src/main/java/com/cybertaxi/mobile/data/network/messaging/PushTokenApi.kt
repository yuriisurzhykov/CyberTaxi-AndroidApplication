package com.cybertaxi.mobile.data.network.messaging

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PushTokenApi {

    @POST("/user/pushes/update")
    suspend fun registerNewPushToken(@Body token: String): Call<ResponseBody>
}