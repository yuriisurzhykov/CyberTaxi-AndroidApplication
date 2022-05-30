package com.cybertaxi.mobile.domain.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach

abstract class Repository<T> {

    open suspend fun fetch() = flow {
        val localData = fetchLocal()
        emitAll(localData)
        val remoteData = fetchRemote()
        emitAll(remoteData)
        remoteData.onEach { storeRemoteData(it) }
    }

    protected abstract suspend fun fetchLocal(): Flow<T>

    protected abstract suspend fun fetchRemote(): Flow<T>

    protected abstract suspend fun storeRemoteData(data: T)

}