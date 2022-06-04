package com.cybertaxi.mobile.data.network.trips

import com.cybertaxi.mobile.data.model.remote.DriverAcceptParams
import com.cybertaxi.mobile.data.model.remote.DriverRemote
import com.cybertaxi.mobile.data.model.remote.OrderCreationParams
import com.cybertaxi.mobile.data.model.remote.OrderRemote
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface TripsCreationApi {

    @POST("/trips/single/create-request")
    suspend fun createOrder(@Body orderParams: OrderCreationParams): Call<OrderRemote>

    @POST("/trips/accept-driver")
    suspend fun acceptDriver(@Body params: DriverAcceptParams): Call<DriverRemote>

    @POST("/trips/group/create-request")
    suspend fun createGroupOrder(@Body orderParams: OrderCreationParams): Call<OrderRemote>

    @POST("/trips/group/join")
    suspend fun joinGroupOrder(@Body jointCode: String): Call<ResponseBody>

}