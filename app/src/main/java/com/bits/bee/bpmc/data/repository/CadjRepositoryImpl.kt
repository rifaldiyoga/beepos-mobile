package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.CadjDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.domain.mapper.CadjDataMapper
import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.repository.CadjRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class CadjRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val cadjDao: CadjDao,
    private val ioDispatcher: CoroutineDispatcher
): CadjRepository {
    override fun getCadjByReftypeInOutHaventUpload(): Flow<Resource<List<Cadj>>> {
        return flow {
            val data = cadjDao.getCadjByReftypeInOutHaventUpload().map { CadjDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(ioDispatcher)
    }

    override suspend fun updateCadj(cadj: Cadj) {
        withContext(ioDispatcher){
            cadjDao.update(CadjDataMapper.fromDomainToDb(cadj))
        }
    }

}