package com.mahle.smartbikesystems.core.api

sealed class Resource<out T> {
    class Loading<out T>: Resource<T>()
    data class Success<out T>(val data: T): Resource<T>()
    data class Failure(val e: Exception): Resource<Nothing>()
}
