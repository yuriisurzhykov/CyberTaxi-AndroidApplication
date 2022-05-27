package com.cybertaxi.core.coroutines

import kotlinx.coroutines.CoroutineScope

interface AsyncLoader {
    fun launchAsync(block: suspend CoroutineScope.() -> Unit)
    fun launchUi(block: suspend CoroutineScope.() -> Unit)
}