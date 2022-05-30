package com.cybertaxi.core

interface Mapper<I, O> {
    fun map(input: I): O

    fun inverseMap(output: O): I

    interface Unit<T> : Mapper<T, kotlin.Unit>
}