package com.bits.bee.bpmc.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.bits.bee.bpmc.data.data_source.local.dao.SyncDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.post.PostAll
import com.bits.bee.bpmc.data.data_source.remote.response.PostAllReturn
import com.bits.bee.bpmc.domain.mapper.SyncDataMapper
import com.bits.bee.bpmc.domain.model.Sync
import com.bits.bee.bpmc.domain.repository.SyncRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.NetworkBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

class SyncRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val syncDao: SyncDao,
    private val ioDispatcher: CoroutineDispatcher
): SyncRepository {

    override fun getDataSync(): Flow<PagingData<Sync>> {
        return Pager(
            config = PagingConfig(
                pageSize = BPMConstants.BPM_LIMIT_PAGINATION,
                maxSize = BPMConstants.BPM_MAX_PAGINATION,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { syncDao.getManualSync() }
        ).flow.mapLatest {
            it.map { SyncDataMapper.fromDbToDomain(it) }
        }.flowOn(ioDispatcher)
    }

    override fun getSaleNotHaveBp(): Flow<Resource<List<Sync>>> {
        return flow {
            val data = syncDao.getSaleNotHaveBp().map { SyncDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(ioDispatcher)
    }

    override fun getSyncHaventUploaded(): Flow<Resource<List<Sync>>> {
        return flow {
            val data = syncDao.getSyncHaventUploaded().map { SyncDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(ioDispatcher)
    }

    override fun postSyncAll(postAll: PostAll): Flow<Resource<PostAllReturn>> {
        return object : NetworkBoundResource<PostAllReturn>() {
            override fun createCall(): Flow<ApiResponse<PostAllReturn>> {
                return apiUtils.getSyncApiService().postSyncAll(postAll)
            }
        }.getAsFlow()
    }

    override fun getManualSyncLandscape(limit: Long, offset: Long): Flow<Resource<List<Sync>>> {
        return flow {
            val data = syncDao.getManualSyncLandscape(limit, offset).map { SyncDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(ioDispatcher)
    }


}