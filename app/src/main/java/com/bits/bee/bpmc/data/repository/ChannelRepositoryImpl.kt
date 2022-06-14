package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ChannelDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ChannelResponse
import com.bits.bee.bpmc.domain.mapper.ChannelDataMapper
import com.bits.bee.bpmc.domain.model.Channel
import com.bits.bee.bpmc.domain.repository.ChannelRepository
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
 * Created by aldi on 29/03/22.
 */
class ChannelRepositoryImpl  @Inject constructor(
    private val apiUtils: ApiUtils,
    private val channelDao: ChannelDao,
    private val ioDispatcher: CoroutineDispatcher
) : ChannelRepository {
    override fun getChannelList(): Flow<Resource<List<Channel>>> {
        return object : NetworkDatabaseBoundResource<List<Channel>, ChannelResponse>(){
            override suspend fun loadFormDB(): List<Channel>? {
                return channelDao.getChannelList().map { ChannelDataMapper.fromDataToDomain(it) }
            }

            override fun shouldFetch(data: List<Channel>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<ChannelResponse>> {
                return apiUtils.getChannelApiService().getChannelList()
            }

            override suspend fun saveCallResult(data: ChannelResponse) {
                channelDao.deleteAll()
                channelDao.insertBulk(data.data.data.map { it.toChannel() })
            }
        }.getAsFlow()
    }

    override fun getActiveChannelList() : Flow<Resource<List<Channel>>> {
        return flow {
            emit(Resource.loading())
            var data : List<Channel> = mutableListOf()
            data = channelDao.getActiveChannelList().map { ChannelDataMapper.fromDataToDomain(it) }
            if(data.isNotEmpty()) {
                emit(Resource.success(data))
            } else {
                emit(Resource.error(null, "Data Kosong"))
            }
        }.flowOn(ioDispatcher)
    }
}