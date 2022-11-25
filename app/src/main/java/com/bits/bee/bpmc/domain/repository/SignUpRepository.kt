package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.remote.response.*
import com.bits.bee.bpmc.domain.model.SignUp
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/08/22.
 */
interface SignUpRepository {

    fun postSignUp(signUp: SignUp) : Flow<Resource<SignUpResponse>>

    fun postVerifSms(code : String , regId : Int) : Flow<Resource<VerifSmsResponse>>

    fun postVerifDb(serial : String) : Flow<Resource<CheckDbResponse>>

    fun postSetupPassword(authKey : String, password : String, pin : String) : Flow<Resource<SetupPasswordResponse>>

    fun getBidangUsaha() : Flow<Resource<BidangUsahaResponse>>

}