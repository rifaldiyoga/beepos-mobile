package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.CmpDao
import com.bits.bee.bpmc.data.data_source.local.dao.SaleDao
import com.bits.bee.bpmc.data.data_source.local.model.SaleEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.CmpResponse
import com.bits.bee.bpmc.domain.mapper.CmpDataMapper
import com.bits.bee.bpmc.domain.mapper.CrcDataMapper
import com.bits.bee.bpmc.domain.mapper.SaleDataMapper
import com.bits.bee.bpmc.domain.model.Cmp
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.CmpRepository
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class CmpRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val cmpDao: CmpDao,
    private val apiUtils: ApiUtils
) : CmpRepository {

    override fun getLatestCmp(): Flow<Resource<Cmp>> {
        return object : NetworkDatabaseBoundResource<Cmp, CmpResponse>() {

            override suspend fun loadFormDB(): Cmp? {
                return CmpDataMapper.fromDbToDomain(cmpDao.getCmp())
            }

            override fun shouldFetch(data: Cmp?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<CmpResponse>> {
                return apiUtils.getCmpApiService().getCmp()
            }

            override suspend fun saveCallResult(data: CmpResponse) {
                cmpDao.insertSingle(CmpDataMapper.fromNetworkToData(data.data))
            }
        }.getAsFlow()
    }

}