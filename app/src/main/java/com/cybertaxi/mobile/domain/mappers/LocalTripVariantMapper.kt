package com.cybertaxi.mobile.domain.mappers

import com.cybertaxi.core.Mapper
import com.cybertaxi.mobile.data.LocalePreferences
import com.cybertaxi.mobile.data.model.local.TripVariantLocal
import com.cybertaxi.mobile.domain.model.TripVariant
import javax.inject.Inject

class LocalTripVariantMapper
@Inject constructor(
    private val localePreferences: LocalePreferences
) : Mapper<TripVariantLocal, TripVariant> {

    override fun map(input: TripVariantLocal): TripVariant {
        return TripVariant(input.backgroundColor, input.title, input.iconUrl)
    }

    override fun inverseMap(output: TripVariant): TripVariantLocal {
        return TripVariantLocal(
            0,
            output.title,
            localePreferences.locale().language,
            output.backgroundColor,
            output.iconUrl
        )
    }
}