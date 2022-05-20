package com.cybertaxi.mobile.presentation.base

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

interface IFragmentActivity {

    fun showFragment(fragment: Fragment) {
        showFragment(fragment, fragment.toString())
    }

    fun showFragment(fragment: Fragment, tag: String)
    fun showDialogFragment(dialogFragment: DialogFragment, tag: String)
}