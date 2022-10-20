package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.data.data_source.remote.response.SignUpResponse
import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.domain.model.SignUp
import com.bits.bee.bpmc.domain.repository.SignUpRepository
import com.bits.bee.bpmc.domain.usecase.member.SearchActiveCityUseCase
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Created by aldi on 30/08/22.
 */
class PostSignUpUseCase @Inject constructor(
    private val signUpRepository: SignUpRepository,
    private val searchActiveCityUseCase: SearchActiveCityUseCase
){

    suspend operator fun invoke(signUp: SignUp, kota : String = "") : Flow<Resource<SignUpResponse>> {
        if(kota.isNotEmpty()) {
            val city: City? = searchActiveCityUseCase(kota).first().firstOrNull()
            signUp.cityId = city?.code.toString()

        }
        return signUpRepository.postSignUp(signUp)
    }

}