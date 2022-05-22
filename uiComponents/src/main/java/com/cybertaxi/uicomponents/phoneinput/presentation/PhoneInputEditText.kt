package com.cybertaxi.uicomponents.phoneinput.presentation

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatEditText
import com.cybertaxi.uicomponents.phoneinput.data.repository.IPhoneDataProvider
import com.cybertaxi.uicomponents.phoneinput.data.repository.PhoneDataRepository
import com.cybertaxi.uicomponents.phoneinput.domain.viewViewModels
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhoneInputEditText : AppCompatEditText {

    @Inject
    private var phoneDataRepository: IPhoneDataProvider? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private fun loadData() {
        phoneDataRepository?.provide {

        }
    }
}