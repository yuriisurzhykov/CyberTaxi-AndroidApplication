package com.cybertaxi.mobile.domain.base

interface ILoginRepository {

    fun authenticate(username: String)

    fun resendCode(username: String)

    fun register(username: String)

    fun logout()
}