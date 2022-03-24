package com.bits.bee.bpmc.data.source.remote

import com.bits.bee.bpmc.data.source.remote.apiservices.AuthApiService
import com.bits.bee.bpmc.data.source.remote.apiservices.BranchApiService
import com.bits.bee.bpmc.data.source.remote.apiservices.CashierApiService
import javax.inject.Inject

/**
 * Created by aldi on 25/02/22.
 */

class ApiUtils @Inject constructor(private val retrofitClient: RetrofitClient) {

    fun getAuthApiService() : AuthApiService {
        return retrofitClient.getClientProvision()!!.create(AuthApiService::class.java)
    }

    fun getBranchApiService() : BranchApiService {
        return retrofitClient.getClientApi()!!.create(BranchApiService::class.java)
    }

    fun getCashierApiService() : CashierApiService {
        return retrofitClient.getClientApi()!!.create(CashierApiService::class.java)
    }

}