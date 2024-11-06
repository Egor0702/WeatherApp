package com.example.core.utils

/**
 * Class for storing information about status of data's state
 */
sealed class DataHolder<out TData> {

    /**
     * Data loading status
     */
    object LOADING : DataHolder<Nothing>()

    /**
     * Data availability status
     *
     * @property data Data are loaded
     */
    class READY<out TData>(val data: TData) : DataHolder<TData>()

    /**
     * Data error status
     *
     * @property failure Information about error
     */
    class ERROR(val failure: Throwable) : DataHolder<Nothing>()

    /**
     * @param block This code will be called if data is ready
     */
    inline fun onReady(block: (TData) -> Unit) {
        if (this is READY) {
            block(this.data)
        }
    }

    /**
     * @param block this code will be called if data is loading
     */
    inline fun onLoading(block: () -> Unit) {
        if (this is LOADING) {
            block()
        }
    }

    /**
     * @param block this code will be called if we got error
     */
    inline fun onError(block: (Throwable) -> Unit) {
        if (this is ERROR) {
            block(failure)
        }
    }

    /**
     * Supportive object
     */
    companion object {
        /**
         * Making [DataHolder] in loading state
         */
        fun loading() = DataHolder.LOADING

        /**
         * Making [DataHolder] in ready state
         */
        fun <TData> ready(data: TData) = DataHolder.READY(data)

        /**
         * Making [DataHolder] in error state
         */
        fun error(failure: Throwable) = DataHolder.ERROR(failure)
    }
}

/**
 * Make [DataHolder] from [kotlin.Result]
 */
fun <T> Result<T>.toDataHolder(): DataHolder<T> = fold(
    onSuccess = { DataHolder.ready(it) },
    onFailure = { DataHolder.error(it) }
)
