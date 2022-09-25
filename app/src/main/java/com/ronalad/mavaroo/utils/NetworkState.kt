package com.ronalad.mavaroo.utils

sealed class NetworkState<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): NetworkState<T>(data = data)
    class ServerError<T>(message: String?): NetworkState<T>(message = message)
    class Error<T>(message: String?): NetworkState<T>(message = message)
}
