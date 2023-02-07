package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.AddOnDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.AddOnResponse
import com.bits.bee.bpmc.domain.mapper.AddOnDataMapper
import com.bits.bee.bpmc.domain.model.AddOn
import com.bits.bee.bpmc.domain.repository.AddOnRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class AddOnRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val addOnDao: AddOnDao,
    private val ioDispatcher: CoroutineDispatcher
) : AddOnRepository{

    override fun getLatestAddOnList(): Flow<Resource<List<AddOn>>> {
        return object : NetworkDatabaseBoundResource<List<AddOn>, AddOnResponse>(){
            override suspend fun loadFormDB(): List<AddOn> {
                return addOnDao.getAddOnList().map { AddOnDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<AddOn>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<AddOnResponse>> {
                return apiUtils.getAddOnApiService().getAddOn()
            }

            override suspend fun saveCallResult(data: AddOnResponse) {
                addOnDao.insertBulk(data.addOnModels.map { AddOnDataMapper.fromNetworkToDb(it) })
            }
        }.getAsFlow()
    }

}