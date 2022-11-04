package com.bits.bee.bpmc.utils

import kotlinx.coroutines.flow.Flow
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by aldi on 15/03/22.
 */

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
