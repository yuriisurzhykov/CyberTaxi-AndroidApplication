package com.cybertaxi.core.list

import androidx.annotation.LayoutRes

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class ViewHolder(@LayoutRes val layoutRes: Int)
