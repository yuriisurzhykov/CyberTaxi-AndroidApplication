package com.cybertaxi.uicomponents.core

interface IProvider<T> {
    suspend fun provide(): T
}

fun interface DataCallback<T> {
    fun onChange(value: T)
}

interface ReactiveProvider<T> {
    fun provide(callback: DataCallback<T>)
}