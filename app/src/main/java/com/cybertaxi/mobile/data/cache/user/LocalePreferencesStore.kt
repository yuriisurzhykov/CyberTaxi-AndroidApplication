package com.cybertaxi.mobile.data.cache.user

import android.content.res.Resources
import com.cybertaxi.mobile.data.LocalePreferences
import java.util.*
import javax.inject.Inject

class LocalePreferencesStore @Inject constructor() : LocalePreferences {

    override fun locale(): Locale {
        return Resources.getSystem().configuration.locales[0]
    }
}