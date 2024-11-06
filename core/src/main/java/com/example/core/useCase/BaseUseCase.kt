package com.example.core.useCase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Base class for use case
 *
 * @property dispatcher The Use Case will be executed on the passed dispatcher
 *
 * Result returns like [kotlin.Result]
 *
 */
abstract class BaseUseCase<in TParam, out TResult>(
    private val dispatcher: CoroutineDispatcher
) {
    /**
     * UseCase realisation
     */
    protected abstract suspend fun execute(param: TParam): TResult

    /**
     * Execute UseCase
     */
    suspend operator fun invoke(param: TParam): Result<TResult> = withContext(dispatcher) {
        runCatching { execute(param) }
    }
}
