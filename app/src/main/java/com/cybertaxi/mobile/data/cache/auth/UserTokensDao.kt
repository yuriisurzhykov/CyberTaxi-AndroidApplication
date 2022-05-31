package com.cybertaxi.mobile.data.cache.auth

import androidx.room.Dao
import androidx.room.Query
import com.cybertaxi.mobile.data.model.local.TokenLocal

@Dao
interface UserTokensDao {

    @Query("SELECT * FROM user_tokens LIMIT 1")
    suspend fun fetchToken(): TokenLocal
}