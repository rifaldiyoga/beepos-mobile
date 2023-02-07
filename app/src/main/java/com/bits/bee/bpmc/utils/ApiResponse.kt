package com.bits.bee.bpmc.utils

import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by aldi on 02/03/22.
 */
sealed class ApiResponse<T> {

    companion object {
        fun <T> create( error: Throwable): ApiResponse<T> {
            return if (error is SocketTimeoutException) {
                ApiTimeoutResponse("ConnectionTimeout")
            } else if(error is UnknownHostException){
                ApiNoNetworkResponse("No Network!")
            } else {
                ApiErrorResponse(
                    error.message ?: "unknown error",
                    402,
                )
            }
        }

        fun <T> create(response: Response<T>): ApiResponse<T> {
            if (response.isSuccessful) {
                val body = response.body()
                val code = response.code()
                return if (body == null || code == 204) {
                    ApiEmptyResponse()
                } else if (code == 503 || code == 404 || code == 401) {
                    ApiUnAuthorizedResponse(
                        "Unauthorized. Token may be invalid.",
                        code
                    )
                } else {
                    ApiSuccessResponse(body)
                }
            } else {
                val code: Int = response.code()
                val msg: String = response.message()

                return if (code == 503 || code == 404 || code == 401) {
                    ApiUnAuthorizedResponse(
                        msg,
                        code
                    )
                } else {
                    ApiErrorResponse(
                        msg,
                        code
                    )
                }
            }
        }
    }
}

/**
 * separate class for HTTP 204 responses so that we can make ApiSuccessResponse's body non-null.
 */

class ApiEmptyResponse<T> : ApiResponse<T>()

data class ApiSuccessResponse<T>(val body: T) : ApiResponse<T>() {}

data class ApiErrorResponse<T>(val errorMessage: String, val code: Int) : ApiResponse<T>()

data class ApiTimeoutResponse<T>(val errorMessage: String) : ApiResponse<T>()

data class ApiNoNetworkResponse<T>(val errorMessage: String) : ApiResponse<T>()

data class ApiUnAuthorizedResponse<T>(val errorMessage: String, val code: Int) : ApiResponse<T>()