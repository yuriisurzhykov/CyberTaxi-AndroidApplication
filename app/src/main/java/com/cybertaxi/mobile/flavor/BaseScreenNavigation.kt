package com.cybertaxi.mobile.flavor

import com.cybertaxi.mobile.presentation.main.MainPassengerActivity

open class BaseScreenNavigation : IScreenNavigation {
    override fun startAppActivityClass(): Class<*> = MainPassengerActivity::class.java
}