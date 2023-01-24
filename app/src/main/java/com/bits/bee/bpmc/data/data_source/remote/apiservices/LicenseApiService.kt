package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.model.DetachPost
import com.bits.bee.bpmc.data.data_source.remote.model.LicensePost
import com.bits.bee.bpmc.data.data_source.remote.post.CheckLicPost
import com.bits.bee.bpmc.data.data_source.remote.response.CheckLicResponse
import com.bits.bee.bpmc.data.data_source.remote.response.DetachResponse
import com.bits.bee.bpmc.data.data_source.remote.response.LicenseResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by aldi on 06/09/22
 */

interface LicenseApiService {

    @POST("/api/v1/activatedevice")
    fun postLic(@Body licpost: LicensePost) : Flow<ApiResponse<LicenseResponse>>

    @POST("/api/v1/detachdevice")
    fun detachLic(@Body detachPost: DetachPost): Flow<ApiResponse<DetachResponse>>

    @POST("/api/v2/checklicense")
    fun postCheckLic(@Body checklic: CheckLicPost): Flow<ApiResponse<CheckLicResponse>>

}