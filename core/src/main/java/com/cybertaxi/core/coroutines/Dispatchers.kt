package com.cybertaxi.core.coroutines

import kotlinx.coroutines.*

interface Dispatchers {

    fun launchUi(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit): Job

    fun launchBackground(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit): Job

    suspend fun changeToUi(block: suspend CoroutineScope.() -> Unit)

    abstract class Abstract(
        private val ui: CoroutineDispatcher,
        private val background: CoroutineDispatcher
    ) : Dispatchers {

        override fun launchUi(
            scope: CoroutineScope,
            block: suspend CoroutineScope.() -> Unit
        ): Job = scope.launch(ui, block = block)

        override fun launchBackground(
            scope: CoroutineScope,
            block: suspend CoroutineScope.() -> Unit
        ): Job = scope.launch(background, block = block)

        override suspend fun changeToUi(block: suspend CoroutineScope.() -> Unit) =
            withContext(ui, block = block)
    }

    class Base : Abstract(kotlinx.coroutines.Dispatchers.Main, kotlinx.coroutines.Dispatchers.IO)
}