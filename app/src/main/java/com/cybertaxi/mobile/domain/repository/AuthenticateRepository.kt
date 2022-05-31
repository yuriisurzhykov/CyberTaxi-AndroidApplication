package com.cybertaxi.mobile.domain.repository

import com.cybertaxi.mobile.domain.base.ILoginRepository
import javax.inject.Inject

class AuthenticateRepository @Inject constructor(

) : ILoginRepository {

    override fun authenticate(username: String) {
        TODO("Not yet implemented")
    }

    override fun resendCode(username: String) {
        TODO("Not yet implemented")
    }

    override fun register(username: String) {
        TODO("Not yet implemented")
    }

    override fun logout() {
        TODO("Not yet implemented")
    }
}