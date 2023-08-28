package ru.fakelog.vkot.core.data.data_source.local.db

import android.util.Log
import ru.fakelog.vkot.core.domain.utils.FailureStatus
import ru.fakelog.vkot.core.domain.utils.Result
import javax.inject.Inject

open class BaseLocalDataSource @Inject constructor() {

    suspend fun <T> safeDbCall(call: suspend () -> T): Result<T> {
        try {
            return when (val response = call.invoke()) {
                null -> {
                    Result.Failure(FailureStatus.EMPTY)
                }

                is List<*> -> {
                    return if ((response as List<*>).isNotEmpty()) {
                        Result.Success(response)
                    } else {
                        Result.Failure(FailureStatus.EMPTY)
                    }
                }

                else -> {
                    Log.d("sddg", "test")
                    Result.Success(response)
                }
            }
        } catch (throwable: Throwable) {
            when (throwable) {
                else -> {
                    Log.e("DataBase Response", throwable.toString())
                    return Result.Failure(FailureStatus.OTHER)
                }
            }
        }
    }
}