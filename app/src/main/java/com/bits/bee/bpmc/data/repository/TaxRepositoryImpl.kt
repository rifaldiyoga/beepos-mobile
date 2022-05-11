package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.TaxDao
import com.bits.bee.bpmc.data.data_source.local.model.Tax
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.TaxResponse
import com.bits.bee.bpmc.domain.repository.TaxRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class TaxRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val taxDao: TaxDao
) : TaxRepository {

     override fun getLatestTaxList(): Flow<Resource<List<Tax>>> {
        return object : NetworkDatabaseBoundResource<List<Tax>, TaxResponse>(){
            override suspend fun loadFormDB(): List<Tax>? {
                return taxDao.getTaxList()
            }

            override fun shouldFetch(data: List<Tax>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<TaxResponse>> {
                return apiUtils.getTaxApiService().getTaxList()
            }

            override suspend fun saveCallResult(data: TaxResponse) {
                taxDao.deleteAll()
                taxDao.insertBulk(data.data.data.map { it.toTax() })
            }
        }.getAsFlow()
    }
}