package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.post.SetupPasswordPost
import com.bits.bee.bpmc.data.data_source.remote.post.SignUpPost
import com.bits.bee.bpmc.data.data_source.remote.post.VerifDbPost
import com.bits.bee.bpmc.data.data_source.remote.post.VerifSmsPost
import com.bits.bee.bpmc.data.data_source.remote.response.*
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST


/**
 * Created by aldi on 30/08/22.
 */
interface SignUpApiService {

    @POST("/rest/trial/signup")
    fun postRegister(@Body signUpPost: SignUpPost?): Flow<ApiResponse<SignUpResponse>>

    @GET("/rest/trial/usaha")
    fun getBidangUsaha() : Flow<ApiResponse<BidangUsahaResponse>>

    @GET("/rest/trial/city")
    fun getCity() : Flow<ApiResponse<CityResponse>>

    @POST("/rest/trial/confirm-sms")
    fun postVerifSms(@Body verifsmsPost: VerifSmsPost): Flow<ApiResponse<VerifSmsResponse>>

    @POST("/rest/trial/change-pass-with-authkey")
    fun postSetupPassword(@Body setupPasswordPost: SetupPasswordPost): Flow<ApiResponse<SetupPasswordResponse>>

    @POST("/rest/trial/check-db")
    fun postVerifDb(@Body verifDbPost: VerifDbPost): Flow<ApiResponse<SetupPasswordResponse>>

}