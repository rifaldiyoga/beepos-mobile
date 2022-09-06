package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.data.data_source.remote.response.VerifSmsResponse
import com.bits.bee.bpmc.domain.repository.SignUpRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/08/22.
 */
class PostVerifSmsUseCase @Inject constructor(
    private val signUpRepository: SignUpRepository,
){

    operator fun invoke(code : String, regId : Int) : Flow<Resource<VerifSmsResponse>> {
        return signUpRepository.postVerifSms(code, regId)
    }

}