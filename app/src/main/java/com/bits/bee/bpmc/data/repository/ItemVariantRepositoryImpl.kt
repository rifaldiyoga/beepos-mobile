package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ItemVariantDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ItemVariantResponse
import com.bits.bee.bpmc.domain.mapper.ItemVariantDataMapper
import com.bits.bee.bpmc.domain.model.ItemVariant
import com.bits.bee.bpmc.domain.repository.ItemVariantRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class ItemVariantRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val itemVariantDao: ItemVariantDao,
    private val ioDispatcher: CoroutineDispatcher
) : ItemVariantRepository{

    override fun getLatestItemVariantList(): Flow<Resource<List<ItemVariant>>> {
        return object : NetworkDatabaseBoundResource<List<ItemVariant>, ItemVariantResponse>(){
            override suspend fun loadFormDB(): List<ItemVariant> {
                return itemVariantDao.getItemVariantList().map { ItemVariantDataMapper.fromDbToDomain(it)!! }
            }

            override fun shouldFetch(data: List<ItemVariant>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<ItemVariantResponse>> {
                return apiUtils.getItemVariantApiService().getItemVariant()
            }

            override suspend fun saveCallResult(data: ItemVariantResponse) {
                itemVariantDao.insertBulk(data.itemVariantModels.map { ItemVariantDataMapper.fromNetworkToData(it) })
            }
        }.getAsFlow()
    }

}