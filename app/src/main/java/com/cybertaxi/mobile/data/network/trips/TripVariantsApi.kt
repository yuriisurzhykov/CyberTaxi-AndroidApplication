package com.cybertaxi.mobile.data.network.trips

import com.cybertaxi.mobile.data.model.remote.TripVariantRemote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TripVariantsApi {

    @GET("/trips/variants")
    suspend fun fetchTripVariants(): Call<List<TripVariantRemote>>

}