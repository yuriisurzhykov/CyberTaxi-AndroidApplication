package com.cybertaxi.mobile.core

interface Mapper<I, O> {
    fun map(input: I): O

    interface Unit<T> : Mapper<T, kotlin.Unit>
}