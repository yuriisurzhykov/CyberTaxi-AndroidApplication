package com.cybertaxi.mobile.di

import android.content.Context
import com.cybertaxi.mobile.data.DevicePreferences
import com.cybertaxi.mobile.data.LocalePreferences
import com.cybertaxi.mobile.data.TokenPreferences
import com.cybertaxi.mobile.data.UserPreferences
import com.cybertaxi.mobile.data.cache.auth.UserTokensDao
import com.cybertaxi.mobile.data.cache.user.DevicePreferencesStorage
import com.cybertaxi.mobile.data.cache.user.LocalePreferencesStore
import com.cybertaxi.mobile.data.cache.user.TokenPreferencesStorage
import com.cybertaxi.mobile.data.cache.user.UserPreferencesStorage
import com.cybertaxi.mobile.data.encryption.HashCipher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Provides
    fun provideTokenPreferences(userTokensDao: UserTokensDao): TokenPreferences {
        return TokenPreferencesStorage(userTokensDao)
    }

    @Provides
    @Singleton
    fun devicePreferences(@ApplicationContext context: Context, hashCipher: HashCipher): DevicePreferences {
        return DevicePreferencesStorage(context, hashCipher)
    }

    @Provides
    @Singleton
    fun provideLanguagePreferences(): LocalePreferences {
        return LocalePreferencesStore()
    }

    @Provides
    @Singleton
    fun provideUserPreferences(
        devicePreferences: DevicePreferences,
        languagePreferences: LocalePreferences,
        tokenPreferences: TokenPreferences
    ): UserPreferences {
        return UserPreferencesStorage(devicePreferences, languagePreferences, tokenPreferences)
    }
}