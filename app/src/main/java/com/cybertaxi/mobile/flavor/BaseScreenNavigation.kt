package com.cybertaxi.mobile.flavor

import com.cybertaxi.mobile.presentation.base.MapsBottomSheetNavigationActivity
import com.cybertaxi.mobile.presentation.main.MainPassengerActivity

open class BaseScreenNavigation : IScreenNavigation {
    override fun startAppActivityClass(): Class<*> = MapsBottomSheetNavigationActivity::class.java
}