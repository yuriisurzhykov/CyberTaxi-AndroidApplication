package com.cybertaxi.mobile.presentation.menu

import androidx.recyclerview.widget.DiffUtil
import com.cybertaxi.mobile.presentation.base.list.AbstractRecyclerAdapter
import com.cybertaxi.mobile.presentation.base.list.AbstractViewHolder
import kotlin.reflect.KClass

open class MenuRecyclerAdapter<VH : AbstractViewHolder<MenuItem>>(vhClazz: KClass<VH>) :
    AbstractRecyclerAdapter<MenuItem, VH>(vhClazz) {

    override fun createDiffUtil(oldItems: List<MenuItem>, newItems: List<MenuItem>): DiffUtil.Callback {
        return MenuItemDiffUtilCallback(oldItems, newItems)
    }
}