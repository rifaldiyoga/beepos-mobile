package com.bits.bee.bpmc.data.data_source.remote

import com.bits.bee.bpmc.BuildConfig.*
import com.bits.bee.bpmc.utils.FlowCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Created by aldi on 25/02/22.
 */
class RetrofitClient {
    private var retrofit: Retrofit? = null

    companion object{
        var API_KEY : String = ""
    }

    fun getClientProvision(url : String = API_PROVISION): Retrofit? {
        val interceptor = HttpLoggingInterceptor()
        if (DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        val baseUrl: String = url
        try {
            val timeout = 7
            val client = OkHttpClient.Builder()
                .connectTimeout(timeout.toLong(), TimeUnit.MINUTES)
                .readTimeout(timeout.toLong(), TimeUnit.MINUTES)
                .writeTimeout(timeout.toLong(), TimeUnit.MINUTES)
                .addNetworkInterceptor(AddHeaderInterceptor(""))
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
        if (DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        val baseUrl: String = API
        try {
            val timeout = 7
            val client = OkHttpClient.Builder()
                .connectTimeout(timeout.toLong(), TimeUnit.MINUTES)
                .readTimeout(timeout.toLong(), TimeUnit.MINUTES)
                .writeTimeout(timeout.toLong(), TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .addNetworkInterceptor(AddHeaderInterceptor(
                    "Bearer $API_KEY"
                )).build()
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

    private class AddHeaderInterceptor(val apiKey : String) : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val builder: Request.Builder = chain.request().newBuilder()
            builder.addHeader("Content-Type", "application/json")
            builder.addHeader("Authorization", apiKey)
            builder.method(chain.request().method, chain.request().body)
            return chain.proceed(builder.build())
        }
    }

}