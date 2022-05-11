package com.bits.bee.bpmc.di

import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitClient() = RetrofitClient()

    @Provides
    @Singleton
    fun provideUtilsApi(retrofitClient: RetrofitClient) : ApiUtils {
        return ApiUtils(retrofitClient)
    }
}