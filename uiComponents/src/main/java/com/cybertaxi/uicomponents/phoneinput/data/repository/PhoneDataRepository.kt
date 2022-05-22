package com.cybertaxi.uicomponents.phoneinput.data.repository

import com.cybertaxi.uicomponents.core.DataCallback
import com.cybertaxi.uicomponents.phoneinput.data.PhoneData
import javax.inject.Inject

class PhoneDataRepository @Inject constructor(
    private val phoneDataProvider: IPhoneDataProvider,
) :
    IPhoneDataProvider {
    override fun provide(callback: DataCallback<List<PhoneData>>) {

    }
}