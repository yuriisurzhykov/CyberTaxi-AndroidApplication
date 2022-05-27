package com.cybertaxi.mobile.presentation.base

import androidx.recyclerview.widget.DiffUtil

abstract class AbstractDiffUtilCallback<T>(
    protected val oldItems: List<T>,
    protected val newItems: List<T>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] === newItems[newItemPosition]
    }
}