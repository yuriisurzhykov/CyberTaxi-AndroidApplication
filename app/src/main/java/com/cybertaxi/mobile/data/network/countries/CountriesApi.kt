package com.cybertaxi.mobile.data.network.countries

import com.cybertaxi.mobile.data.model.remote.CountryRemote
import retrofit2.http.GET

interface CountriesApi {

    @GET("/minor/countries")
    suspend fun fetchCountries(): List<CountryRemote>
}