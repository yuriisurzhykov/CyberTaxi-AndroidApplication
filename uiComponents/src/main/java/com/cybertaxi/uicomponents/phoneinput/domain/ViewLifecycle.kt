package com.cybertaxi.uicomponents.phoneinput.domain

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

class ViewLifecycle(view: View) : Lifecycle() {

    private var mCurrentViewState: State = State.DESTROYED

    init {
        view.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View?) {
                mCurrentViewState = State.CREATED
            }

            override fun onViewDetachedFromWindow(v: View?) {
                mCurrentViewState = State.DESTROYED
            }
        })
    }

    private val observers = mutableListOf<LifecycleObserver>()

    override fun addObserver(observer: LifecycleObserver) {
        observers.add(observer)
    }

    override fun removeObserver(observer: LifecycleObserver) {
        observers.remove(observer)
    }

    override fun getCurrentState() = mCurrentViewState
}