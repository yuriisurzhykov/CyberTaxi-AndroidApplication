package com.cybertaxi.mobile.data.network

import com.cybertaxi.mobile.data.model.remote.TripVariantRemote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TripVariantsApi {

    @GET("/trips/variants")
    suspend fun fetchTripVariants(@Query("lang") language: String): Call<List<TripVariantRemote>>

}