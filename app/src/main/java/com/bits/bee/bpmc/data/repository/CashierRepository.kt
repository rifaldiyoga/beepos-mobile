package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.source.local.dao.CashierDao
import com.bits.bee.bpmc.data.source.local.model.Cashier
import com.bits.bee.bpmc.data.source.remote.ApiUtils
import com.bits.bee.bpmc.data.source.remote.response.CashierResponse
import com.bits.bee.bpmc.domain.repository.CashierRepositoryI
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 17/03/22.
 */
class CashierRepository @Inject constructor(
    private val apiUtils: ApiUtils,
    private val cashierDao: CashierDao
) : CashierRepositoryI{

    override fun getCashierList(): Flow<Resource<List<Cashier>>> {
        return object : NetworkDatabaseBoundResource<List<Cashier>, CashierResponse>(){
            override suspend fun loadFormDB(): List<Cashier>? {
                return cashierDao.getListCashier()
            }

            override fun shouldFetch(data: List<Cashier>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<CashierResponse>> {
                return apiUtils.getCashierApiService().getCashierList()
            }

            override suspend fun saveCallResult(data: CashierResponse) {
                cashierDao.insertBulk(data.data.data.map { it.toCashierEntity() })
            }

        }.getAsFlow()
    }

}