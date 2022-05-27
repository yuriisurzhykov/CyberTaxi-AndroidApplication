package com.cybertaxi.core.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KClass

class BaseViewHolderFactory<VH : RecyclerView.ViewHolder>(
    private val inflater: LayoutInflater
) : ViewHolderFactory<VH> {

    override fun create(clazz: KClass<VH>, parent: ViewGroup, viewType: Int): VH {
        if (clazz.java.isAnnotationPresent(ViewHolder::class.java)) {
            val annotation =
                clazz.annotations.find { it is ViewHolder } as? ViewHolder
            if (annotation != null) {
                val view = inflater.inflate(annotation.layoutRes, parent, false)
                return clazz.java.getConstructor(View::class.java).newInstance(view)
            }
        }
        throw IllegalArgumentException("Illegal class $clazz! You must to annotate it with @ViewHolder annotation!")
    }
}