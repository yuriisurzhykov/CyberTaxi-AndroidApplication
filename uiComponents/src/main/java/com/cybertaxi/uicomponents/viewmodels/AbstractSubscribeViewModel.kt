package com.cybertaxi.uicomponents.viewmodels

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cybertaxi.core.coroutines.AsyncLoader
import com.cybertaxi.core.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope

abstract class AbstractSubscribeViewModel<T : IView>
constructor(protected val dispatchers: Dispatchers) : ViewModel(), AsyncLoader {

    protected val viewModelCallbackStore = ViewModelLifecycleCallback<T>()

    fun startLoad() {
        launchAsync { loadBackground() }
    }

    override fun launchAsync(block: suspend CoroutineScope.() -> Unit) {
        dispatchers.launchBackground(viewModelScope, block)
    }

    override fun launchUi(block: suspend CoroutineScope.() -> Unit) {
        dispatchers.launchUi(viewModelScope, block)
    }

    protected abstract suspend fun loadBackground()

    open fun subscribe(owner: LifecycleOwner, callback: T) {
        viewModelCallbackStore.init(owner, callback)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelCallbackStore.clear()
    }
}