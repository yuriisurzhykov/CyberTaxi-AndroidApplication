package com.cybertaxi.mobile.presentation.main

import android.graphics.Color
import com.cybertaxi.core.coroutines.Dispatchers
import com.cybertaxi.mobile.menu.MenuItem
import com.cybertaxi.uicomponents.viewmodels.AbstractSubscribeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    dispatchers: Dispatchers
) : AbstractSubscribeViewModel<IMainView>(dispatchers) {

    override suspend fun loadBackground() {
        postTripType(
            listOf(
                MenuItem("Single ride", Color.GRAY),
                MenuItem("Group ride", Color.RED),
                MenuItem("Delivery", Color.GREEN)
            )
        )
    }

    private suspend fun postTripType(list: List<MenuItem>) {
        dispatchers.changeToUi { viewModelCallbackStore.getCallback()?.drawTripTypes(list) }
    }
}