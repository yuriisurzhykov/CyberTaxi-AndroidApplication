package com.cybertaxi.mobile.presentation.login

import com.cybertaxi.core.coroutines.Dispatchers
import com.cybertaxi.mobile.domain.model.Country
import com.cybertaxi.mobile.domain.usecase.CountriesUseCase
import com.cybertaxi.uicomponents.viewmodels.AbstractSubscribeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginPhoneInputViewModel @Inject constructor(
    dispatchers: Dispatchers,
    private val countriesUseCase: CountriesUseCase
) : AbstractSubscribeViewModel<ILoginPhoneInputView>(dispatchers) {

    override suspend fun loadBackground() {
        countriesUseCase.fetch().onEach { postCountriesToUi(it) }
    }

    private suspend fun postCountriesToUi(list: List<Country>) {
        dispatchers.changeToUi { viewModelCallbackStore.getCallback()?.drawCountries(list) }
    }
}