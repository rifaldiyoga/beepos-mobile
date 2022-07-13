package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ItemBranchDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ItemBranchResponse
import com.bits.bee.bpmc.domain.mapper.ItemBranchDataMapper
import com.bits.bee.bpmc.domain.model.ItemBranch
import com.bits.bee.bpmc.domain.repository.ItemBranchRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class ItemBranchRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val itemBranchDao: ItemBranchDao,
    private val ioDispatcher: CoroutineDispatcher
) : ItemBranchRepository{

    override fun getLatestItemBranchList(): Flow<Resource<List<ItemBranch>>> {
        return object : NetworkDatabaseBoundResource<List<ItemBranch>, ItemBranchResponse>(){
            override suspend fun loadFormDB(): List<ItemBranch> {
                return itemBranchDao.getItemBranchList().map { ItemBranchDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<ItemBranch>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<ItemBranchResponse>> {
                return apiUtils.getItemBranchApiService().getItemBranch()
            }

            override suspend fun saveCallResult(data: ItemBranchResponse) {
                itemBranchDao.insertBulk(data.itemBranch.itemBranchModels.map { ItemBranchDataMapper.fromNetworkToDb(it) } )
            }
        }.getAsFlow()
    }
}