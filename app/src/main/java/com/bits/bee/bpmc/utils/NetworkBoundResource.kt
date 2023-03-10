package com.bits.bee.bpmc.utils

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.TidakAdaAksesDialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext


/**
 * Created by aldi on 02/03/22.
 */

abstract class NetworkDatabaseBoundResource<ResultType, RequestType> @MainThread constructor (
    private val isNextPage: Boolean = false
) {

    private val result : Flow<Resource<ResultType>> = channelFlow {
        send(Resource.loading())

        if(shouldFetch(null)) {
            when (val apiResponse = createCall().first()) {
                is ApiErrorResponse -> {
                    send(Resource.error(null, apiResponse.errorMessage, apiResponse.code))
                }
                is ApiSuccessResponse -> {
                    withContext(Dispatchers.IO) {
                        val a = processResponse(apiResponse)
                        saveCallResult(a)
                        val data = loadFormDB()
                        data?.let {
                            send(Resource.success(it))
                        }
                    }
                }
                is ApiTimeoutResponse -> {
                    send(Resource.timeout(null, apiResponse.errorMessage))
                }
                is ApiUnAuthorizedResponse -> {
                    send(Resource.unauthorized(null, apiResponse.errorMessage, apiResponse.code))
                }
                is ApiEmptyResponse -> {

                }
                is ApiNoNetworkResponse -> {
                    send(Resource.noInternet(null, apiResponse.errorMessage, 400))
                }
            }
        } else {
            withContext(Dispatchers.IO) {
                val data = loadFormDB()
                data?.let {
                    send(Resource.success(it))
                }
            }
        }
    }


    @WorkerThread
    private fun processResponse(response: ApiSuccessResponse<RequestType>): RequestType {
        return response.body
    }

    fun getAsFlow(): Flow<Resource<ResultType>> {
        return result
    }

    protected abstract suspend fun loadFormDB() : ResultType?

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    @MainThread
    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>


    protected abstract suspend fun saveCallResult(data: RequestType)

}

abstract class NetworkBoundResource<RequestObject> @MainThread constructor(private val isNextPage: Boolean = false) {

    private val result : Flow<Resource<RequestObject>> = flow {
        emit(Resource.loading())
        when(val apiResponse = createCall().first()){
            is ApiErrorResponse -> {
                emit(Resource.error(null, apiResponse.errorMessage, apiResponse.code))
            }
            is ApiSuccessResponse -> {
                val a = processResponse(apiResponse)
                saveCallResult(a)
                emit(Resource.success(a))
            }
            is ApiTimeoutResponse -> {
                emit(Resource.timeout(null, apiResponse.errorMessage))
            }
            is ApiUnAuthorizedResponse -> {
                emit(Resource.unauthorized(null, apiResponse.errorMessage, apiResponse.code))
            }
            is ApiEmptyResponse -> {}
            is ApiNoNetworkResponse -> {
                emit(Resource.noInternet(null, apiResponse.errorMessage, 505))
            }
        }
    }

    @WorkerThread
    private fun processResponse(response: ApiSuccessResponse<RequestObject>): RequestObject {
        return response.body
    }

    fun getAsFlow(): Flow<Resource<RequestObject>> {
        return result
    }

    @MainThread
    protected abstract fun createCall(): Flow<ApiResponse<RequestObject>>

    open suspend fun saveCallResult(data : RequestObject){

    }
}