package com.cybertaxi.mobile.domain.mappers

import com.cybertaxi.core.Mapper
import com.cybertaxi.mobile.data.LocalePreferences
import com.cybertaxi.mobile.data.model.remote.TripVariantRemote
import com.cybertaxi.mobile.domain.model.TripVariant
import javax.inject.Inject

class RemoteTripVariantMapper
@Inject constructor(
    private val localePreferences: LocalePreferences
) : Mapper<TripVariantRemote, TripVariant> {

    override fun map(input: TripVariantRemote): TripVariant {
        return TripVariant(input.backgroundColor, input.title, input.iconUrl, input.variantValue)
    }

    override fun inverseMap(output: TripVariant): TripVariantRemote {
        return TripVariantRemote(
            output.title,
            localePreferences.locale().language,
            output.stringId,
            output.backgroundColor,
            output.iconUrl
        )
    }
}