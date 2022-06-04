package com.cybertaxi.mobile.domain.usecase

import com.cybertaxi.mobile.domain.base.Repository
import com.cybertaxi.mobile.domain.base.UseCase
import com.cybertaxi.mobile.domain.model.Country
import javax.inject.Inject

class CountriesUseCase @Inject constructor(
    private val countriesRepository: Repository<List<Country>>
) : UseCase<List<Country>> {
    override suspend fun fetch() = countriesRepository.fetch()
}