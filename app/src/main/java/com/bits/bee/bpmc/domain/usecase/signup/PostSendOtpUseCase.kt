package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.data.data_source.remote.response.SendOtpResponse
import com.bits.bee.bpmc.domain.repository.SignUpRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/08/22.
 */
class PostSendOtpUseCase @Inject constructor(
    private val signUpRepository: SignUpRepository,
){

    operator fun invoke(code : String, regId : Int) : Flow<Resource<SendOtpResponse>> {
        return signUpRepository.postSendOtp(code, regId)
    }

}