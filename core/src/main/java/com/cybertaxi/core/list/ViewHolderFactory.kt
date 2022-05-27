package com.cybertaxi.core.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KClass

interface ViewHolderFactory<VH : RecyclerView.ViewHolder> {

    fun create(clazz: KClass<VH>, parent: ViewGroup, viewType: Int): VH
}

