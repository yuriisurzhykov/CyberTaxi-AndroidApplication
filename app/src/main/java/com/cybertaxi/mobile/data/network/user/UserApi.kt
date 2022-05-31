package com.cybertaxi.mobile.data.network.user

import com.cybertaxi.mobile.data.model.remote.UserRemote
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.POST

interface UserApi {

    @POST("/user/edit")
    suspend fun editProfile(userData: UserRemote): Call<ResponseBody>
    
}