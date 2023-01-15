package com.treemiddle.core_domain.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class ResultUseCase<T, R>(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {
    protected abstract suspend fun execute(params: T): R

    suspend operator fun invoke(params: T): Result<R> {
        return try {
            withContext(dispatcher) {
                execute(params).let {
                    Result.Success(it)
                }
            }
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}
