package com.cybertaxi.mobile.presentation.main

import com.cybertaxi.mobile.domain.model.TripVariant
import com.cybertaxi.mobile.presentation.base.AbstractDiffUtilCallback

class TripVariantDiffUtil(oldList: List<TripVariant>, newList: List<TripVariant>) :
    AbstractDiffUtilCallback<TripVariant>(oldList, newList) {

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].title == newItems[newItemPosition].title &&
                oldItems[oldItemPosition].backgroundColor == newItems[newItemPosition].backgroundColor &&
                oldItems[oldItemPosition].iconUrl == newItems[newItemPosition].iconUrl
    }
}