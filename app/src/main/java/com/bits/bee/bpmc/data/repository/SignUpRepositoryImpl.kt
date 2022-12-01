package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.post.SendOtpPost
import com.bits.bee.bpmc.data.data_source.remote.post.SetupPasswordPost
import com.bits.bee.bpmc.data.data_source.remote.post.VerifDbPost
import com.bits.bee.bpmc.data.data_source.remote.post.VerifSmsPost
import com.bits.bee.bpmc.data.data_source.remote.response.*
import com.bits.bee.bpmc.domain.mapper.SignUpDataMapper
import com.bits.bee.bpmc.domain.model.SignUp
import com.bits.bee.bpmc.domain.repository.SignUpRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/08/22.
 */
class SignUpRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils
) : SignUpRepository {

    override fun postSignUp(signUp: SignUp): Flow<Resource<SignUpResponse>> {
        return object : NetworkBoundResource<SignUpResponse>(){
            override fun createCall(): Flow<ApiResponse<SignUpResponse>> {
                return apiUtils.getSignUpApiService().postRegister(SignUpDataMapper.fromDomainToNetwork(signUp))
            }
        }.getAsFlow()
    }

    override fun postVerifSms(code: String, regId: Int): Flow<Resource<VerifSmsResponse>> {
        val verifSmsPost = VerifSmsPost(code = code, regid = regId, status = true)
        return object : NetworkBoundResource<VerifSmsResponse>(){
            override fun createCall(): Flow<ApiResponse<VerifSmsResponse>> {
                return apiUtils.getSignUpApiService().postVerifSms(verifSmsPost)
            }
        }.getAsFlow()
    }

    override fun postSendOtp(otpTipe: String, regId: Int): Flow<Resource<SendOtpResponse>> {
        val verifSmsPost = SendOtpPost(otpTipe, regId.toString())
        return object : NetworkBoundResource<SendOtpResponse>(){
            override fun createCall(): Flow<ApiResponse<SendOtpResponse>> {
                return apiUtils.getSignUpApiService().postSendOtp(verifSmsPost)
            }
        }.getAsFlow()
    }

    override fun postVerifDb(serial: String): Flow<Resource<CheckDbResponse>> {
        val verifSmsPost = VerifDbPost(serial = serial)
        return object : NetworkBoundResource<CheckDbResponse>(){
            override fun createCall(): Flow<ApiResponse<CheckDbResponse>> {
                return apiUtils.getSignUpApiService().postVerifDb(verifSmsPost)
            }
        }.getAsFlow()
    }

    override fun postSetupPassword(
        authKey : String,
        password: String,
        pin: String
    ): Flow<Resource<SetupPasswordResponse>> {
        val post = SetupPasswordPost(true, authKey, password, pin)
        return object : NetworkBoundResource<SetupPasswordResponse>(){
            override fun createCall(): Flow<ApiResponse<SetupPasswordResponse>> {
                return apiUtils.getSignUpApiService().postSetupPassword(post)
            }
        }.getAsFlow()
    }

    override fun getBidangUsaha(): Flow<Resource<BidangUsahaResponse>> {
        return object : NetworkBoundResource<BidangUsahaResponse>() {
            override fun createCall(): Flow<ApiResponse<BidangUsahaResponse>> {
                return apiUtils.getSignUpApiService().getBidangUsaha()
            }
        }.getAsFlow()
    }

}