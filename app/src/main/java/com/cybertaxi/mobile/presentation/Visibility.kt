package com.cybertaxi.mobile.presentation

import android.view.View

interface Visibility {

    fun apply(view: View)

    abstract class Abstract(private val visibility: Int) : Visibility {
        override fun apply(view: View) {
            view.visibility = visibility
        }
    }

    object Visible : Abstract(View.VISIBLE)
    object Gone : Abstract(View.GONE)
    object Invisible : Abstract(View.INVISIBLE)
}