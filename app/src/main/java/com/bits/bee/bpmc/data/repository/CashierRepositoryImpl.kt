package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.CashierDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.CashierResponse
import com.bits.bee.bpmc.domain.mapper.BranchDataMapper
import com.bits.bee.bpmc.domain.mapper.CashierDataMapper
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.repository.CashierRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 17/03/22.
 */
class CashierRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val cashierDao: CashierDao,
    private val defaultDispatcher: CoroutineDispatcher
) : CashierRepository {

    override fun getCashierList(branchId : Int): Flow<Resource<List<Cashier>>> {

        return object : NetworkDatabaseBoundResource<List<Cashier>, CashierResponse>(){
            override suspend fun loadFormDB(): List<Cashier> {
                return cashierDao.getListCashier().map { CashierDataMapper.fromDataToDomain(it) }
            }

            override fun shouldFetch(data: List<Cashier>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<CashierResponse>> {
                return apiUtils.getCashierApiService().getCashierList(branchId)
            }

            override suspend fun saveCallResult(data: CashierResponse) {
                cashierDao.insertBulk(data.data.cashierModels.map { CashierDataMapper.fromResponseToData(it) })
            }

        }.getAsFlow()
    }

    override suspend fun updateActiveCashier(cashier: Cashier) {
        withContext(defaultDispatcher){
            cashierDao.resetActive()
            cashierDao.update(CashierDataMapper.fromDomainToData(cashier))
        }
    }

    override fun getActiveCashier(): Flow<Cashier?> = flow{
        var cashier : Cashier? = null
        cashierDao.getActiveCashier()?.let {
            cashier = CashierDataMapper.fromDataToDomain(it)
        }
        emit(cashier)
    }.flowOn(defaultDispatcher)

}