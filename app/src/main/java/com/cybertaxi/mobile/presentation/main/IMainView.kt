package com.cybertaxi.mobile.presentation.main

import com.cybertaxi.mobile.domain.model.TripVariant
import com.cybertaxi.mobile.presentation.menu.MenuItem
import com.cybertaxi.uicomponents.viewmodels.IView

interface IMainView : IView {

    fun drawTripTypes(list: List<TripVariant>)

}