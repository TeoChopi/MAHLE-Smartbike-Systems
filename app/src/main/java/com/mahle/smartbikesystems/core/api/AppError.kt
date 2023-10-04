package com.mahle.smartbikesystems.core.api

data class AppError(val apiErrorCode: String = "", val apiMessage: String = "") : Exception(apiMessage)


fun <T> Throwable.toAppFailure(): AppResult.Failure<T> {
    return AppResult.failure(AppError(this.toString(), this.message ?: "error"))
}