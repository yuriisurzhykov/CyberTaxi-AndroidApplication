package com.cybertaxi.uicomponents.phoneinput.domain

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

inline fun <reified T : ViewModel> View.viewViewModels(noinline factory: () -> ViewModelProvider.Factory = { ViewModelProvider.NewInstanceFactory() }): Lazy<T> {
    val viewModelStore = { (context.applicationContext as ViewModelStoreOwner).viewModelStore }
    return ViewModelLazy(T::class, viewModelStore, factory)
}