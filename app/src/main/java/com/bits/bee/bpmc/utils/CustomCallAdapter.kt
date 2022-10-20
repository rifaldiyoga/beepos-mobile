package com.bits.bee.bpmc.utils

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.coroutines.resumeWithException

/**
 * Created by aldi on 15/03/22.
 */

class ResponseCallAdapter<T>(
    private val responseType: Type
) : CallAdapter<T, Flow<ApiResponse<T>>> {

    override fun responseType() = responseType

    override fun adapt(call: Call<T>): Flow<ApiResponse<T>> = flow{
        emit(
            suspendCancellableCoroutine { continuation ->
                call.enqueue(object : Callback<T> {
                    override fun onFailure(call: Call<T>, t: Throwable) {
                        continuation.resume(ApiResponse.create(t)){}
                    }

                    override fun onResponse(call: Call<T>, response: Response<T>) {
                        continuation.resume(ApiResponse.create(response)){}
                    }
                })
                continuation.invokeOnCancellation {
                    call.cancel()
                }
            }
        )
    }

}


class BodyCallAdapter<T>(private val responseType: Type) : CallAdapter<T, Flow<T>> {
    override fun adapt(call: Call<T>): Flow<T> {
        return flow {
            emit(
                suspendCancellableCoroutine { continuation ->
                    call.enqueue(object : Callback<T> {
                        override fun onFailure(call: Call<T>, t: Throwable) {
                            continuation.resumeWithException(t)
                        }

                        override fun onResponse(call: Call<T>, response: Response<T>) {
                            try {
                                continuation.resume(response.body()!!){}
                            } catch (e: Exception) {
                                continuation.resumeWithException(e)
                            }
                        }
                    })
                    continuation.invokeOnCancellation { call.cancel() }
                }
            )
        }
    }

    override fun responseType() = responseType
}

