package com.cybertaxi.common

import com.cybertaxi.mobile.flavor.IFlavor
import com.cybertaxi.driver.flavor.DriverScreenNavigation

object Flavor : IFlavor {

    private val screenNavigation = DriverScreenNavigation()

    override fun screenNavigation() = screenNavigation
}