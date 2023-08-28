package ru.fakelog.vkot.core.domain.utils

sealed class Result<out T> {

    object Default : Result<Nothing>()

    class Failure(
        val failureStatus: FailureStatus,
        val code: Int? = null,
        val message: String? = null
    ) : Result<Nothing>()

    object Loading : Result<Nothing>()

    class Success<out T>(val value: T) : Result<T>()
}