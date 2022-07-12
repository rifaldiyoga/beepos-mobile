package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.AddOnDDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse
import com.bits.bee.bpmc.domain.mapper.AddOnDDataMapper
import com.bits.bee.bpmc.domain.model.AddOnD
import com.bits.bee.bpmc.domain.repository.AddOnDRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class AddOnDRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val addOnDDao: AddOnDDao,
    private val ioDispatcher: CoroutineDispatcher
) : AddOnDRepository{

    override fun getLatestAddOnDList(): Flow<Resource<List<AddOnD>>> {
        return object : NetworkDatabaseBoundResource<List<AddOnD>, AddOnDResponse>(){
            override suspend fun loadFormDB(): List<AddOnD> {
                return addOnDDao.getAddOnDList().map { AddOnDDataMapper.fromDbToDomain(it)!! }
            }

            override fun shouldFetch(data: List<AddOnD>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<AddOnDResponse>> {
                return apiUtils.getAddOnDApiService().getAddOnD()
            }

            override suspend fun saveCallResult(data: AddOnDResponse) {
                addOnDDao.insertBulk(data.data.map { AddOnDDataMapper.fromNetworkToData(it) })
            }
        }.getAsFlow()
    }

}