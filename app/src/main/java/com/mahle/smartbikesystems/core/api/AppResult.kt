package com.mahle.smartbikesystems.core.api


sealed class AppResult<T>{

    data class Success<T>(val data: T) : AppResult<T>()
    data class Failure<T>(val exception: AppError) : AppResult<T>()

    companion object {
        fun <T> success(data: T) = Success(data)
        fun <T> failure(exception: AppError) = Failure<T>(exception)
    }
}

inline fun <R, T> AppResult<T>.fold(
    onSuccess: (T) -> R,
    onFailure: (exception: AppError) -> R
): R {
    return when(this){
        is AppResult.Success -> onSuccess(data)
        is AppResult.Failure -> onFailure(exception)
    }
}
