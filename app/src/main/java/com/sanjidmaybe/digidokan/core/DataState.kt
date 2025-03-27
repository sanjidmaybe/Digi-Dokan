package com.sanjidmaybe.digidokan.core

sealed class DataState <T>(
    var message: String? = null,
    val data: T? = null
) {
    class Loading<T> : DataState<T>()
    class Success <T> (sData: T?) : DataState<T>(data = sData)
    class Error<T> (message: String): DataState<T>(message)
}