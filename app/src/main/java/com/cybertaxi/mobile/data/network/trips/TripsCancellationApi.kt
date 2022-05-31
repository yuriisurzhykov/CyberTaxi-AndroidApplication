package com.cybertaxi.mobile.data.network.trips

import com.cybertaxi.mobile.data.model.remote.OrderRemote
import com.cybertaxi.mobile.data.model.remote.TripCancellationReasonRemote
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface TripsCancellationApi {

    @POST("/trips/cancel")
    suspend fun cancelOrder(order: OrderRemote): Call<ResponseBody>

    @GET("/trips/cancel/reasons")
    suspend fun fetchReasons(): Call<List<TripCancellationReasonRemote>>

}