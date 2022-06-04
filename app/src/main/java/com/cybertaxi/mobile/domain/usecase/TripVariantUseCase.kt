package com.cybertaxi.mobile.domain.usecase

import com.cybertaxi.mobile.domain.base.Repository
import com.cybertaxi.mobile.domain.base.UseCase
import com.cybertaxi.mobile.domain.model.TripVariant
import javax.inject.Inject

class TripVariantUseCase @Inject constructor(
    private val repository: Repository<List<TripVariant>>
) : UseCase<List<TripVariant>> {

    override suspend fun fetch() = repository.fetch()

}