package com.cybertaxi.common

import com.cybertaxi.mobile.flavor.BaseScreenNavigation
import com.cybertaxi.mobile.flavor.IFlavor

object Flavor : IFlavor {

    private val screenNavigation = BaseScreenNavigation()

    override fun screenNavigation() = screenNavigation
}