package com.cybertaxi.mobile.menu.holder

import android.view.View
import android.widget.TextView
import com.cybertaxi.mobile.presentation.base.list.AbstractViewHolder
import com.cybertaxi.mobile.presentation.base.list.ViewHolder
import com.cybertaxi.mobile.R
import com.cybertaxi.mobile.menu.MenuItem

@ViewHolder(layoutRes = R.layout.list_item_trip_type)
class TripTypeViewHolder(view: View) : AbstractViewHolder<MenuItem>(view) {

    private val title by lazy(LazyThreadSafetyMode.NONE) {
        itemView.findViewById<TextView>(R.id.trip_name)
    }

    override fun bind(item: MenuItem) {
        title.text = item.title
        itemView.setBackgroundColor(item.backgroundColor)
    }
}