package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.SelectionDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.SelectionResponse
import com.bits.bee.bpmc.domain.mapper.SelectionDataMapper
import com.bits.bee.bpmc.domain.model.Selection
import com.bits.bee.bpmc.domain.repository.SelectionRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class SelectionRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val selectionDao: SelectionDao,
    private val ioDispatcher: CoroutineDispatcher
) : SelectionRepository{

    override fun getLatestSelectionList(): Flow<Resource<List<Selection>>> {
        return object : NetworkDatabaseBoundResource<List<Selection>, SelectionResponse>(){
            override suspend fun loadFormDB(): List<Selection> {
                return selectionDao.getSelectionList().map { SelectionDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<Selection>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<SelectionResponse>> {
                return apiUtils.getSelectionApiService().getSelection()
            }

            override suspend fun saveCallResult(data: SelectionResponse) {
                selectionDao.insertBulk(data.selectionModels.map { SelectionDataMapper.fromNetworkToDb(it) })
            }
        }.getAsFlow()
    }

    override fun getSelectionByItem(itemId: Int): Flow<List<Selection>> = flow {
        emit(selectionDao.getSelectionByItemid(itemId).map { SelectionDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

}