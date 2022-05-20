package com.cybertaxi.mobile.presentation.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class AbstractFragment<VM : ViewModel> : Fragment() {

    protected abstract val layoutRes: Int
    protected abstract val viewModelClass: Class<VM>

//    private val viewModel: VM by viewModels()
}