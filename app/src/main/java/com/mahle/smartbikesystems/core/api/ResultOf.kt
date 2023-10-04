package com.mahle.smartbikesystems.core.api

sealed class ResultOf<out T> {
    data class Success<out R>(val value: R): ResultOf<R>()
    data class Failure(val requestFailure: RequestFailure): ResultOf<Nothing>()
}