package com.cybertaxi.mobile.data

interface Result<out R> {

    data class Success<out T>(val data: T) : Result<T>

    abstract class Error(val exception: Exception) : Result<Nothing>
}

class LocalDataFetchException(ex: Exception) : Result.Error(ex)

class RemoteDataFetchException(ex: Exception) : Result.Error(ex)