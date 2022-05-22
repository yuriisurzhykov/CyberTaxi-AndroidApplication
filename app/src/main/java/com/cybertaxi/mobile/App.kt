package com.cybertaxi.mobile

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

class App : Application(), ViewModelStoreOwner {

    override fun getViewModelStore(): ViewModelStore = singletonViewModelStore

    companion object {
        private val singletonViewModelStore = ViewModelStore()
    }
}