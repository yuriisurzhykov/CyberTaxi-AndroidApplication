package com.cybertaxi.mobile.presentation.main

import android.os.Bundle
import com.cybertaxi.mobile.R
import com.cybertaxi.mobile.presentation.base.AbstractFragmentActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPassengerActivity : AbstractFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_profile_edit)
        MainMenuBottomSheetFragment().show(
            supportFragmentManager,
            MainMenuBottomSheetFragment::class.simpleName
        )
    }
}