package com.cybertaxi.mobile.domain.base

import kotlinx.coroutines.flow.Flow

interface UseCase<I> {
    suspend fun fetch(): Flow<I>
}