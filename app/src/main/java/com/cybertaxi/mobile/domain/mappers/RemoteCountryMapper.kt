package com.cybertaxi.mobile.domain.mappers

import com.cybertaxi.core.Mapper
import com.cybertaxi.mobile.data.model.remote.CountryRemote
import com.cybertaxi.mobile.domain.model.Country
import javax.inject.Inject

class RemoteCountryMapper @Inject constructor() : Mapper<CountryRemote, Country> {

    override fun map(input: CountryRemote): Country {
        return Country(input.countryName, input.countryCode, input.phoneCode, input.phoneLength, input.locale)
    }

    override fun inverseMap(output: Country): CountryRemote {
        return CountryRemote(
            output.countryCode,
            output.countryName,
            output.locale,
            output.phoneCode,
            output.phoneLength
        )
    }
}