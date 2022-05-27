package com.cybertaxi.uicomponents.views

import android.view.View

interface Visibility {

    fun apply(view: View?)

    abstract class Abstract(private val visibility: Int) : Visibility {
        override fun apply(view: View?) {
            if (view?.visibility != visibility) {
                view?.visibility = visibility
            }
        }
    }

    object Visible : Abstract(View.VISIBLE)
    object Invisible : Abstract(View.INVISIBLE)
    object Gone : Abstract(View.GONE)
}