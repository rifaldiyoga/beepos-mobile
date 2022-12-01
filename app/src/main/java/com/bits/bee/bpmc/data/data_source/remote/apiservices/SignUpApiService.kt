package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.post.*
import com.bits.bee.bpmc.data.data_source.remote.response.*
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.RequestBody
import retrofit2.http.*


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

    @POST("/rest/trial/send-otp")
    fun postSendOtp(@Body verifsmsPost: SendOtpPost): Flow<ApiResponse<SendOtpResponse>>

    @POST("/rest/trial/change-pass-with-authkey")
    fun postSetupPassword(@Body setupPasswordPost: SetupPasswordPost): Flow<ApiResponse<SetupPasswordResponse>>

    @POST("/rest/trial/check-db")
    fun postVerifDb(@Body verifDbPost: VerifDbPost): Flow<ApiResponse<CheckDbResponse>>

}
