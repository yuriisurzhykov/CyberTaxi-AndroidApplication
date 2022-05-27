package com.cybertaxi.mobile.menu

import com.cybertaxi.mobile.presentation.base.AbstractDiffUtilCallback

class MenuItemDiffUtilCallback(
    oldItems: List<MenuItem>,
    newItems: List<MenuItem>
) : AbstractDiffUtilCallback<MenuItem>(oldItems, newItems) {

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}