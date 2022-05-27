package com.cybertaxi.mobile.presentation.base.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KClass

abstract class AbstractRecyclerAdapter<T, VH : AbstractViewHolder<T>>(private val clazz: KClass<VH>) :
    RecyclerView.Adapter<VH>() {

    private val dataList = mutableListOf<T>()

    private var onItemClickListener: OnItemClickListener<T>? = null

    private var inflater: LayoutInflater? = null

    abstract fun createDiffUtil(oldItems: List<T>, newItems: List<T>): DiffUtil.Callback

    @Synchronized
    fun setData(data: List<T>) {
        val diffCallback = createDiffUtil(dataList, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)
        dataList.clear()
        dataList.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return BaseViewHolderFactory<VH>(layoutInflater(parent.context)).create(clazz, parent, viewType)
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

    private fun layoutInflater(context: Context): LayoutInflater {
        if (inflater == null) {
            inflater = LayoutInflater.from(context)
        }
        return inflater!!
    }
}