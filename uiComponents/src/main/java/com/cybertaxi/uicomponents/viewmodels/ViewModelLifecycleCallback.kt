package com.cybertaxi.uicomponents.viewmodels

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class ViewModelLifecycleCallback<C> {

    private var callback: C? = null
    private var owner: LifecycleOwner? = null

    fun getCallback() = callback

    fun init(ownerRef: LifecycleOwner, callbackRef: C) {
        clear()
        if (ownerRef.lifecycle.currentState != Lifecycle.State.DESTROYED) {
            callback = callbackRef
            owner = ownerRef
            owner?.lifecycle?.addObserver(stateObserver)
        }
    }

    private val stateObserver = LifecycleEventObserver { _, event ->
        if (event == Lifecycle.Event.ON_DESTROY) {
            clear()
        }
    }

    fun clear() {
        callback = null
        owner?.lifecycle?.removeObserver(stateObserver)
        owner = null
    }

}