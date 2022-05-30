package com.cybertaxi.mobile.presentation.main

import androidx.recyclerview.widget.DiffUtil
import com.cybertaxi.mobile.domain.model.TripVariant
import com.cybertaxi.mobile.presentation.base.list.AbstractRecyclerAdapter
import com.cybertaxi.mobile.presentation.menu.holder.TripTypeViewHolder

class TripVariantsAdapter :
    AbstractRecyclerAdapter<TripVariant, TripTypeViewHolder>(TripTypeViewHolder::class) {
    override fun createDiffUtil(oldItems: List<TripVariant>, newItems: List<TripVariant>): DiffUtil.Callback {
        return TripVariantDiffUtil(oldItems, newItems)
    }
}