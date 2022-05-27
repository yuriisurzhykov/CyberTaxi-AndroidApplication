package com.cybertaxi.mobile.presentation.base.list

import androidx.annotation.LayoutRes

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewHolder(@LayoutRes val layoutRes: Int)