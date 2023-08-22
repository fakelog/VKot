package ru.fakelog.vkot.data.remote

import android.util.Log
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import retrofit2.HttpException
import ru.fakelog.vkot.domain.utils.BaseResponse
import ru.fakelog.vkot.domain.utils.ErrorResponse
import ru.fakelog.vkot.domain.utils.FailureStatus
import ru.fakelog.vkot.domain.utils.Resource
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject

open class BaseRemoteDataSource @Inject constructor() {

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
        try {
            val apiResponse = apiCall.invoke()


            when ((apiResponse as BaseResponse<*>).result) {
                null -> {
                    return Resource.Failure(FailureStatus.EMPTY)
                }
                is List<*> -> {
                    return if ((apiResponse.result as List<*>).isNotEmpty()) {
                        Resource.Success(apiResponse)
                    } else {
                        Resource.Failure(FailureStatus.EMPTY)
                    }
                }
                is Boolean -> {
                    return if (apiResponse.result as Boolean) {
                        Resource.Success(apiResponse)
                    } else {
                        Resource.Failure(FailureStatus.API_FAIL, 200, apiResponse.detail)
                    }
                }
                else -> {
                    return Resource.Success(apiResponse)
                }
            }
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    when {
                        throwable.code() == 422 -> {
                            val errorBody = throwable.response()!!.errorBody()!!.string()
                            val jObjError = Json.decodeFromString(JsonObject.serializer(), errorBody)
                            val apiResponse = jObjError.toString()

                            val response = Json.decodeFromString<BaseResponse<String>>(apiResponse)

                            return Resource.Failure(FailureStatus.API_FAIL, throwable.code(), response.detail)
                        }
                        throwable.code() == 401 -> {
                            val errorResponse = Json.decodeFromString<ErrorResponse>(
                                throwable.response()?.errorBody()!!.charStream().readText()
                            )

                            return Resource.Failure(FailureStatus.API_FAIL, throwable.code(), errorResponse.error_description)
                        }
                        else -> {
                            return if (throwable.response()?.errorBody()!!.charStream().readText().isNullOrEmpty()) {
                                Resource.Failure(FailureStatus.API_FAIL, throwable.code())
                            } else {
                                try {
                                    val errorResponse = Json.decodeFromString<ErrorResponse>(
                                        throwable.response()?.errorBody()!!.charStream().readText()
                                    )

                                    Resource.Failure(FailureStatus.API_FAIL, throwable.code(), errorResponse.error)
                                } catch (ex: Throwable) {
                                    Resource.Failure(FailureStatus.API_FAIL, throwable.code())
                                }
                            }
                        }
                    }
                }

                is UnknownHostException -> {
                    return Resource.Failure(FailureStatus.NO_INTERNET)
                }

                is ConnectException -> {
                    return Resource.Failure(FailureStatus.NO_INTERNET)
                }

                else -> {
                    Log.e("Response", throwable.toString())
                    return Resource.Failure(FailureStatus.OTHER)
                }
            }
        }
    }
}