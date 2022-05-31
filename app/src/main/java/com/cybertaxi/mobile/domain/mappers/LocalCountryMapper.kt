package com.cybertaxi.mobile.domain.mappers

import com.cybertaxi.core.Mapper
import com.cybertaxi.mobile.data.model.local.CountryLocal
import com.cybertaxi.mobile.domain.model.Country
import javax.inject.Inject

class LocalCountryMapper @Inject constructor() : Mapper<CountryLocal, Country> {

    override fun map(input: CountryLocal): Country {
        return Country(input.countryName, input.countryCode, input.phoneCode, input.phoneLength, input.locale)
    }

    override fun inverseMap(output: Country): CountryLocal {
        return CountryLocal(
            0,
            output.countryCode,
            output.countryName,
            output.locale,
            output.phoneCode,
            output.phoneLength
        )
    }
}