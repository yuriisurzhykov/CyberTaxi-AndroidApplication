package com.cybertaxi.mobile.domain.repository

import com.cybertaxi.core.Mapper
import com.cybertaxi.mobile.data.cache.countries.CountriesDao
import com.cybertaxi.mobile.data.model.local.CountryLocal
import com.cybertaxi.mobile.data.model.remote.CountryRemote
import com.cybertaxi.mobile.data.network.countries.CountriesApi
import com.cybertaxi.mobile.domain.base.Repository
import com.cybertaxi.mobile.domain.model.Country
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CountriesRepository @Inject constructor(
    private val countriesApi: CountriesApi,
    private val countriesDao: CountriesDao,
    private val localCountryMapper: Mapper<CountryLocal, Country>,
    private val remoteCountryMapper: Mapper<CountryRemote, Country>
) : Repository<List<Country>>() {

    override suspend fun fetchLocal() = flow {
        emitAll(countriesDao.countries().map { list -> list.map { localCountryMapper.map(it) } })
    }

    override suspend fun fetchRemote() = flow {
        emit(countriesApi.fetchCountries().map { remoteCountryMapper.map(it) })
    }

    override suspend fun storeRemoteData(data: List<Country>) {
        data.forEach { countriesDao.save(localCountryMapper.inverseMap(it)) }
    }
}