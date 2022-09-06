package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.remote.response.BidangUsahaResponse
import com.bits.bee.bpmc.data.data_source.remote.response.SignUpResponse
import com.bits.bee.bpmc.data.data_source.remote.response.VerifSmsResponse
import com.bits.bee.bpmc.domain.model.SignUp
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/08/22.
 */
interface SignUpRepository {

    fun postSignUp(signUp: SignUp) : Flow<Resource<SignUpResponse>>

    fun postVerifSms(code : String , regId : Int) : Flow<Resource<VerifSmsResponse>>

    fun getBidangUsaha() : Flow<Resource<BidangUsahaResponse>>

}