package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ItemSaleTaxDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemSaleTaxEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ItemBranchResponse
import com.bits.bee.bpmc.data.data_source.remote.response.ItemTaxResponse
import com.bits.bee.bpmc.domain.mapper.ItemBranchDataMapper
import com.bits.bee.bpmc.domain.mapper.ItemSaleTaxDataMapper
import com.bits.bee.bpmc.domain.model.ItemBranch
import com.bits.bee.bpmc.domain.model.ItemSaleTax
import com.bits.bee.bpmc.domain.repository.ItemSaleTaxRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class ItemSaleTaxRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val itemSaleTaxDao: ItemSaleTaxDao,
    private val apiUtils: ApiUtils
) : ItemSaleTaxRepository {

    override fun getLatestItemSaleTax(): Flow<Resource<List<ItemSaleTax>>> {
        return object : NetworkDatabaseBoundResource<List<ItemSaleTax>, ItemTaxResponse>() {
            override suspend fun loadFormDB(): List<ItemSaleTax>? {
                return itemSaleTaxDao.getItemSaleTax().map { ItemSaleTaxDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<ItemSaleTax>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<ItemTaxResponse>> {
                return apiUtils.getItemApiService().getItemTax()
            }

            override suspend fun saveCallResult(data: ItemTaxResponse) {
                itemSaleTaxDao.insertBulk(data.data.map { ItemSaleTaxDataMapper.fromNetworkToDb(it) })
            }

        }.getAsFlow()
    }

    override fun getItemTaxByCodeItem(codeItem: String): Flow<ItemSaleTax?> = flow {
        emit(itemSaleTaxDao.getItemTaxByCodeItem(codeItem)?.let { ItemSaleTaxDataMapper.fromDbToDomain(it) })
    }.flowOn(defaultDispatcher)


}