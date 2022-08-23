package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.SelectionDDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.SelectionDResponse
import com.bits.bee.bpmc.domain.mapper.SelectionDDataMapper
import com.bits.bee.bpmc.domain.model.SelectionD
import com.bits.bee.bpmc.domain.repository.SelectionDRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class SelectionDRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val selectionDDao: SelectionDDao,
    private val ioDispatcher: CoroutineDispatcher
) : SelectionDRepository{

    override fun getLatestSelectionDList(): Flow<Resource<List<SelectionD>>> {
        return object : NetworkDatabaseBoundResource<List<SelectionD>, SelectionDResponse>(){
            override suspend fun loadFormDB(): List<SelectionD> {
                return selectionDDao.getSelectionDList().map { SelectionDDataMapper.fromDbToDomain(it)!! }
            }

            override fun shouldFetch(data: List<SelectionD>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<SelectionDResponse>> {
                return apiUtils.getSelectionDApiService().getSelectionD()
            }

            override suspend fun saveCallResult(data: SelectionDResponse) {
                selectionDDao.insertBulk(data.selectionDModels.map { SelectionDDataMapper.fromNetworkToDb(it) })
            }
        }.getAsFlow()
    }

}