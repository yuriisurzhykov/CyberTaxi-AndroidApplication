package com.cybertaxi.mobile.presentation.main

import com.cybertaxi.core.coroutines.Dispatchers
import com.cybertaxi.mobile.domain.model.TripVariant
import com.cybertaxi.mobile.domain.usecase.TripVariantUseCase
import com.cybertaxi.uicomponents.viewmodels.AbstractSubscribeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    dispatchers: Dispatchers,
    private val useCase: TripVariantUseCase
) : AbstractSubscribeViewModel<IMainView>(dispatchers) {

    override suspend fun loadBackground() {
        useCase.fetch().onEach { postTripType(it) }
    }

    private suspend fun postTripType(list: List<TripVariant>) {
        dispatchers.changeToUi { viewModelCallbackStore.getCallback()?.drawTripTypes(list) }
    }
}