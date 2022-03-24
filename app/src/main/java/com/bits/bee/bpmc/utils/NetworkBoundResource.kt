package com.bits.bee.bpmc.utils

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


/**
 * Created by aldi on 02/03/22.
 */

//abstract class NetworkBoundResource<RequestObject> @MainThread constructor() {
//
//    private var result : Flow<Resource<RequestObject>> = flow {
//        emit(Resource.loading())
//
//        when(val apiResponse = createCall().first()){
//            is ApiErrorResponse -> {
//                emit(Resource.error(null, apiResponse.errorMessage, apiResponse.code))
//            }
//            is ApiSuccessResponse -> {
//                val a = processResponse(apiResponse)
//                emit(Resource.success(a))
//            }
//            is ApiTimeoutResponse -> {
//                emit(Resource.timeout(null, apiResponse.errorMessage))
//            }
//            is ApiUnAuthorizedResponse -> {
//                emit(Resource.unauthorized(null, apiResponse.errorMessage, apiResponse.code))
//            }
//        }
//    }
//
//    @WorkerThread
//    private fun processResponse(response: ApiSuccessResponse<RequestObject>): RequestObject {
//        return response.body
//    }
//
//    fun getAsFlow(): Flow<Resource<RequestObject>> {
//        return result
//    }
//
//    @MainThread
//    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestObject>>
//}

abstract class NetworkDatabaseBoundResource<ResultType, RequestType> @MainThread constructor(
    private val isNextPage: Boolean = false
) {

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading()
        callApi()
    }

    private fun callApi() {

        if(shouldFetch(null)) {
            val apiResponse: LiveData<ApiResponse<RequestType>> = createCall()
            result.addSource(apiResponse) {
                result.removeSource(apiResponse)
                when (it) {
                    is ApiSuccessResponse -> {
                        val a = processResponse(it)
                        GlobalScope.launch {
                            saveCallResult(a)
                        }
                        val db = loadFormDB()
                        db?.let {
                            result.postValue(db?.let { it.map { Resource.success(it) }.value })
                        }

                    }
                    is ApiErrorResponse -> {
                        result.postValue(Resource.error(null, it.errorMessage, it.code,))
                    }
                    is ApiTimeoutResponse -> {
                        result.postValue(Resource.timeout(null, it.errorMessage))
                    }
                    is ApiUnAuthorizedResponse -> {
                        result.postValue(Resource.unauthorized(null, it.errorMessage, it.code))
                    }
                }
            }
        } else {
            val data = loadFormDB()
            data?.let {
                result.postValue(it.map {Resource.success(it)}.value)
            }
        }
    }


    @WorkerThread
    private fun processResponse(response: ApiSuccessResponse<RequestType>): RequestType {
        return response.body
    }

    fun getAsLiveData(): LiveData<Resource<ResultType>> {
        return result
    }

    protected abstract fun loadFormDB() : LiveData<ResultType>?

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    @MainThread
    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

}

abstract class NetworkBoundResource<RequestObject> @MainThread constructor(private val isNextPage: Boolean = false) {

    private val result = MediatorLiveData<Resource<RequestObject>>()

    init {
        result.value = Resource.loading()
        callApi()
    }

    private fun callApi() {
        val apiResponse: LiveData<ApiResponse<RequestObject>> = createCall()
        result.addSource(apiResponse) {
            result.removeSource(apiResponse)
            when (it) {
                is ApiSuccessResponse -> {
                    val a = processResponse(it)
                    result.postValue(Resource.success(a))
                }
                is ApiErrorResponse -> {
                    result.postValue(Resource.error(null, it.errorMessage, it.code))
                }
                is ApiTimeoutResponse -> {
                    result.postValue(Resource.timeout(null, it.errorMessage))
                }
                is ApiUnAuthorizedResponse -> {
                    result.postValue(Resource.unauthorized(null, it.errorMessage, it.code))
                }
            }
        }
    }

    @WorkerThread
    private fun processResponse(response: ApiSuccessResponse<RequestObject>): RequestObject {
        return response.body
    }

    fun getAsLiveData(): LiveData<Resource<RequestObject>> {
        return result
    }

    @MainThread
    protected abstract fun createCall(): LiveData<ApiResponse<RequestObject>>
}