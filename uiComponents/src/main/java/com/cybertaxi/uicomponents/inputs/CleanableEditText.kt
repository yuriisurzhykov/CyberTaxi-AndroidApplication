package com.cybertaxi.uicomponents.inputs

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import com.google.android.material.textfield.TextInputEditText


@SuppressLint("ClickableViewAccessibility")
open class CleanableEditText : TextInputEditText {

    private val DRAWABLE_LEFT = 0
    private val DRAWABLE_TOP = 1
    private val DRAWABLE_RIGHT = 2
    private val DRAWABLE_BOTTOM = 3

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                return@setOnTouchListener onTouched(event)
            }
            false
        }
    }

    protected open fun onTouched(event: MotionEvent): Boolean {
        if (event.rawX >= right - compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
            clearValue()
            return true
        }
        return false
    }

    protected open fun clearValue() {
        text = null
    }
}