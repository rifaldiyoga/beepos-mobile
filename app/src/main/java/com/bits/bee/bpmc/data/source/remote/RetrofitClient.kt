package com.bits.bee.bpmc.data.source.remote

import com.bits.bee.bpmc.BuildConfig.*
import com.bits.bee.bpmc.utils.CustomCallAdapterFactory
import com.bits.bee.bpmc.utils.FlowCallAdapterFactory
import com.bits.bee.bpmc.utils.LiveDataCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Created by aldi on 25/02/22.
 */
class RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClientProvision(): Retrofit? {
        val interceptor = HttpLoggingInterceptor()
        val baseUrl: String = if (DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            API_PROVISION
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            API_PROVISION
        }
        try {
            val timeout = 7
            val client = OkHttpClient.Builder()
                .connectTimeout(timeout.toLong(), TimeUnit.MINUTES)
                .readTimeout(timeout.toLong(), TimeUnit.MINUTES)
                .writeTimeout(timeout.toLong(), TimeUnit.MINUTES)
                .addInterceptor(interceptor).build()
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(FlowCallAdapterFactory.create())
//                .addConverterFactory(MoshiConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return retrofit
    }

    fun getClientApi(): Retrofit? {
        val interceptor = HttpLoggingInterceptor()
        val baseUrl: String = if (DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            API
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
            API
        }
        try {
            val timeout = 7
            val client = OkHttpClient.Builder()
                .connectTimeout(timeout.toLong(), TimeUnit.MINUTES)
                .readTimeout(timeout.toLong(), TimeUnit.MINUTES)
                .writeTimeout(timeout.toLong(), TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .addNetworkInterceptor(AddHeaderInterceptor()).build()
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(FlowCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return retrofit
    }

    private class AddHeaderInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val builder: Request.Builder = chain.request().newBuilder()
            builder.addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1MiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhcGliYy5iZWUuaWRcL2RldiIsImp0aSI6IjgyNzBlYzQwZGU3Y2YyYzA2NGQ4ODM4YTJlYjAwOTY3IiwiZGJuYW1lIjoic2hhZmlyYSIsImRiaG9zdCI6IjEwLjEzMC4wLjc1IiwidXNlcl9pZCI6IjMifQ.eLOg-GPUOZL-1_UDsR-DNpvS5UvlfABR5WABz-EI5Tg")
            builder.method(chain.request().method, chain.request().body)
            return chain.proceed(builder.build())
        }
    }

}