package com.bits.bee.bpmc.data.repository

import androidx.lifecycle.LiveData
import com.bits.bee.bpmc.data.source.remote.ApiUtils
import com.bits.bee.bpmc.data.source.remote.response.CashierResponse
import com.bits.bee.bpmc.domain.repository.CashierRepositoryI
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkBoundResource
import com.bits.bee.bpmc.utils.Resource
import javax.inject.Inject

/**
 * Created by aldi on 17/03/22.
 */
class CashierRepository @Inject constructor(
    private val apiUtils: ApiUtils,
) : CashierRepositoryI{

    override fun getCashierList(): LiveData<Resource<CashierResponse>> {
        return object : NetworkBoundResource< CashierResponse>(){

            override fun createCall(): LiveData<ApiResponse<CashierResponse>> {
                return apiUtils.getCashierApiService().getListCashier()
            }

        }.getAsLiveData()
    }

}