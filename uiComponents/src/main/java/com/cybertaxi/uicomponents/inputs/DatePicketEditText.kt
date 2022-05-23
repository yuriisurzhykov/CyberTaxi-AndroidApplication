package com.cybertaxi.uicomponents.inputs

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import com.cybertaxi.uicomponents.R
import com.cybertaxi.uicomponents.closeKeyboard
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("ClickableViewAccessibility")
class DatePicketEditText : CleanableEditText {

    private val defaultDateFormat = "dd MMMM, yyyy"
    private val simpleDateFormat: SimpleDateFormat

    constructor(context: Context) : super(context) {
        simpleDateFormat = SimpleDateFormat(defaultDateFormat, Locale.getDefault())
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        context.obtainStyledAttributes(attrs, R.styleable.DatePicketEditText, 0, 0).run {
            val dateFormat =
                getString(R.styleable.DatePicketEditText_dateFormat) ?: defaultDateFormat
            simpleDateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())
            recycle()
        }
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        context.obtainStyledAttributes(attrs, R.styleable.DatePicketEditText, 0, 0).run {
            val dateFormat =
                getString(R.styleable.DatePicketEditText_dateFormat) ?: defaultDateFormat
            simpleDateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())
            recycle()
        }
    }

    init {
        setOnFocusChangeListener { v, hasFocus ->
            if (v == this && hasFocus) {
                closeKeyboard()
                openDatePicker()
            }
        }
    }

    override fun onTouched(event: MotionEvent): Boolean {
        val superTouch = super.onTouched(event)
        if (!superTouch) {
            openDatePicker()
            return true
        }
        return superTouch
    }

    private fun openDatePicker() {
        val datePicker = DatePickerDialog(context)
        datePicker.setOnDateSetListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance(Locale.getDefault())
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            val date = simpleDateFormat.format(calendar.time)
            setText(date)
        }
        datePicker.show()
    }
}