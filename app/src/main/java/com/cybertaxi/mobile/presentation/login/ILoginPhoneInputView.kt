package com.cybertaxi.mobile.presentation.login

import com.cybertaxi.mobile.domain.model.Country
import com.cybertaxi.uicomponents.viewmodels.IView

interface ILoginPhoneInputView : IView {

    fun drawCountries(countries: List<Country>)
}