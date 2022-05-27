package com.cybertaxi.mobile.presentation.main

import com.cybertaxi.mobile.menu.MenuItem
import com.cybertaxi.uicomponents.viewmodels.IView

interface IMainView : IView {

    fun drawTripTypes(list: List<MenuItem>)

}