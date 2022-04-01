package com.bits.bee.bpmc.utils

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by aldi on 15/03/22.
 */

class LiveDataCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != ApiResponse::class.java) {
            return null
        }
        val observableType = getParameterUpperBound(0, returnType as ParameterizedType)
        val rawObservableType = getRawType(observableType)
        if (rawObservableType != ApiResponse::class.java) {
            throw IllegalArgumentException("type must be a resource")
        }
        if (observableType !is ParameterizedType) {
            throw IllegalArgumentException("resource must be parameterized")
        }
        val bodyType = getParameterUpperBound(0, observableType)
        return LiveDataCallAdapter<Any>(bodyType)
    }

    companion object {
        @JvmStatic
        fun create() = LiveDataCallAdapterFactory()
    }
}

class FlowCallAdapterFactory private constructor() : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? = when(getRawType(returnType)){
        Flow::class.java -> {
            check(returnType is ParameterizedType) {
                "Flow return type must be parameterized as Flow<Foo> or Flow<out Foo>"
            }
            val flowType = getParameterUpperBound(0, returnType)
            val rawFlowType = getRawType(flowType)
            if (rawFlowType == ApiResponse::class.java) {
                check(flowType is ParameterizedType) {
                    "Response must be parameterized as Response<Foo> or Response<out Foo>"
                }
                val apiResponseType = getParameterUpperBound(0, flowType)
                ResponseCallAdapter<Any>(
                    apiResponseType
                )
            } else {
                BodyCallAdapter<Any>(flowType)
            }
        }
        else -> {
            null
        }
    }


    companion object {
        @JvmStatic
        fun create() = FlowCallAdapterFactory()
    }
}

class CustomCallAdapterFactory private constructor() : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        return ResponseCallAdapter<Any>(
            returnType
        )
    }


    companion object {
        @JvmStatic
        fun create() = CustomCallAdapterFactory()
    }
}