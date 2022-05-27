package com.cybertaxi.mobile.presentation.base.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    private var item: T? = null
    private var onItemClickListener: OnItemClickListener<T>? = null
    private val internalClickListener = View.OnClickListener {
        item?.let { item -> onItemClickListener?.onItemClick(item) }
    }

    init {
        itemView.setOnClickListener(internalClickListener)
    }

    fun setOnClickListener(onItemClickListener: OnItemClickListener<T>?) {
        this.onItemClickListener = onItemClickListener
    }

    abstract fun bind(item: T)

}