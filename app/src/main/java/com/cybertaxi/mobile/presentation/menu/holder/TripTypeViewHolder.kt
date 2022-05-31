package com.cybertaxi.mobile.presentation.menu.holder

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.cybertaxi.mobile.R
import com.cybertaxi.mobile.domain.model.TripVariant
import com.cybertaxi.mobile.presentation.base.list.AbstractViewHolder
import com.cybertaxi.mobile.presentation.base.list.ViewHolder

@SuppressLint("NonConstantResourceId")
@ViewHolder(layoutRes = R.layout.list_item_trip_type)
class TripTypeViewHolder(view: View) : AbstractViewHolder<TripVariant>(view) {

    private val title by lazy(LazyThreadSafetyMode.NONE) {
        itemView.findViewById<TextView>(R.id.trip_name)
    }

    private val icon by lazy(LazyThreadSafetyMode.NONE) {
        itemView.findViewById<ImageView>(R.id.trip_type_icon)
    }

    override fun bind(item: TripVariant) {
        title.text = item.title
        icon.load(item.iconUrl)
        itemView.setBackgroundColor(item.backgroundColor)
    }
}