package com.cybertaxi.mobile.data.cache.user

import com.cybertaxi.mobile.data.TokenPreferences
import com.cybertaxi.mobile.data.cache.auth.UserTokensDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class TokenPreferencesStorage
@Inject
constructor(
    private val userTokensDao: UserTokensDao
) : TokenPreferences {

    override fun accessToken(): String {
        return runBlocking(Dispatchers.IO) {
            userTokensDao.fetchToken().tokenValue
        }
    }
}