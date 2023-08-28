package ru.fakelog.vkot.core.data.data_source.remote

import android.util.Log
import ru.fakelog.vkot.core.domain.utils.FailureStatus
import ru.fakelog.vkot.core.domain.utils.Result
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject

open class BaseRemoteDataSource @Inject constructor() {

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
        try {
            return when (val response = apiCall.invoke()) {
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
                    Result.Success(response)
                }
            }



//            when (apiResponse) {
//                null -> {
//                    Log.e("ffs", apiResponse.toString())
//                    return Resource.Failure(FailureStatus.EMPTY)
//                }
//                is List<*> -> {
//                    return if ((apiResponse.result as List<*>).isNotEmpty()) {
//                        Log.e("ffs2", apiResponse.toString())
//                        Resource.Success(apiResponse)
//                    } else {
//                        Resource.Failure(FailureStatus.EMPTY)
//                    }
//                }
//                is Boolean -> {
//                    Log.e("ffs232", apiResponse.toString())
//                    return if (apiResponse.result as Boolean) {
//                        Resource.Success(apiResponse)
//                    } else {
//                        Resource.Failure(FailureStatus.API_FAIL, 200, apiResponse.detail)
//                    }
//                }
//                else -> {
//                    return Resource.Success(apiResponse)
//                }
//            }
        } catch (throwable: Throwable) {
            when (throwable) {
//                is HttpException -> {
//                    when {
//                        throwable.code() == 422 -> {
//                            val errorBody = throwable.response()!!.errorBody()!!.string()
//                            val jObjError = Json.decodeFromString(JsonObject.serializer(), errorBody)
//                            val apiResponse = jObjError.toString()
//
//                            val response = Json.decodeFromString<BaseResponse<String>>(apiResponse)
//
//                            return Resource.Failure(FailureStatus.API_FAIL, throwable.code(), response.detail)
//                        }
//                        throwable.code() == 401 -> {
//                            val errorResponse = Json.decodeFromString<ErrorResponse>(
//                                throwable.response()?.errorBody()!!.charStream().readText()
//                            )
//
//                            return Resource.Failure(FailureStatus.API_FAIL, throwable.code(), errorResponse.description)
//                        }
//                        else -> {
//                            return if (throwable.response()?.errorBody()!!.charStream().readText().isNullOrEmpty()) {
//                                Resource.Failure(FailureStatus.API_FAIL, throwable.code())
//                            } else {
//                                try {
//                                    val errorResponse = Json.decodeFromString<ErrorResponse>(
//                                        throwable.response()?.errorBody()!!.charStream().readText()
//                                    )
//
//                                    Resource.Failure(FailureStatus.API_FAIL, throwable.code(), errorResponse.error)
//                                } catch (ex: Throwable) {
//                                    Resource.Failure(FailureStatus.API_FAIL, throwable.code())
//                                }
//                            }
//                        }
//                    }
//                }

                is UnknownHostException -> {
                    return Result.Failure(FailureStatus.NO_INTERNET)
                }

                is ConnectException -> {
                    return Result.Failure(FailureStatus.NO_INTERNET)
                }

                else -> {
                    Log.e("Response", throwable.toString())
                    return Result.Failure(FailureStatus.OTHER)
                }
            }
        }
    }
}