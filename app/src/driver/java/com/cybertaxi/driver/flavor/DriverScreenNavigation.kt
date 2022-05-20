package com.cybertaxi.driver.flavor

import com.cybertaxi.driver.main.DriverMainActivity
import com.cybertaxi.mobile.flavor.IScreenNavigation

class DriverScreenNavigation : IScreenNavigation {
    override fun startAppActivityClass() = DriverMainActivity::class.java
}