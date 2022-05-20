package com.cybertaxi.mobile.presentation.base.list

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractRecyclerAdapter<T, VH : AbstractViewHolder<T>> :
    RecyclerView.Adapter<VH>() {

    private val dataList = mutableListOf<T>()

    private var onItemClickListener: OnItemClickListener<T>? = null

    abstract fun createDiffUtil(oldItems: List<T>, newItems: List<T>): DiffUtil.Callback

    @Synchronized
    fun setData(data: List<T>) {
        val diffCallback = createDiffUtil(dataList, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)
        dataList.clear()
        dataList.addAll(data)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    override fun onViewAttachedToWindow(holder: VH) {
        super.onViewAttachedToWindow(holder)
        holder.setOnClickListener(onItemClickListener)
    }

    override fun onViewDetachedFromWindow(holder: VH) {
        super.onViewDetachedFromWindow(holder)
        holder.setOnClickListener(null)
    }
}