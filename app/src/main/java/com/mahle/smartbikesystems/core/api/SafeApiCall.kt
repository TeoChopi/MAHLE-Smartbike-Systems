package com.mahle.smartbikesystems.core.api

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlin.experimental.ExperimentalTypeInference

suspend fun <T> ApiService.safeCall(call: suspend ApiService.() -> T): AppResult<T> {
    return try {
        AppResult.success(call())
    } catch (throwable: Throwable) {
        throwable.toAppFailure()
    }
}

@OptIn(ExperimentalTypeInference::class)
fun <T> apiFlow(@BuilderInference block: suspend FlowCollector<AppResult<T>>.() -> Unit): Flow<AppResult<T>> {
    return flow(block).catch { emit(it.toAppFailure()) }
}