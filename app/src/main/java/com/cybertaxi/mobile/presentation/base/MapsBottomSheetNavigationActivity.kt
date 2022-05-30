package com.cybertaxi.mobile.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cybertaxi.mobile.R
import com.cybertaxi.mobile.presentation.main.MainMenuBottomSheetFragment
import com.cybertaxi.mobile.presentation.main.MainMenuFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class MapsBottomSheetNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps_sheet_navigation)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MainMenuFragment(), "asdda")
            .addToBackStack("asdda")
            .commit()
    }
}