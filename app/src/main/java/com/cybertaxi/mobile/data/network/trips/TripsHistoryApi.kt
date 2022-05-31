package com.cybertaxi.mobile.data.network.trips

import com.cybertaxi.mobile.data.model.remote.OrderRemote
import retrofit2.Call
import retrofit2.http.GET

interface TripsHistoryApi {

    @GET("/trips/recent")
    suspend fun fetchRecentTrips(): Call<List<OrderRemote>>

}