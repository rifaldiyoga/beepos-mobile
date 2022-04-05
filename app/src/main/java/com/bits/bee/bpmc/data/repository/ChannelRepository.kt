package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.source.local.dao.ChannelDao
import com.bits.bee.bpmc.data.source.local.model.Channel
import com.bits.bee.bpmc.data.source.remote.ApiUtils
import com.bits.bee.bpmc.data.source.remote.response.ChannelResponse
import com.bits.bee.bpmc.domain.repository.ChannelRepositoryI
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 29/03/22.
 */
class ChannelRepository  @Inject constructor(
    private val apiUtils: ApiUtils,
    private val channelDao: ChannelDao
) : ChannelRepositoryI {

    override fun getChannelList(): Flow<Resource<List<Channel>>> {
        return object : NetworkDatabaseBoundResource<List<Channel>, ChannelResponse>(){
            override suspend fun loadFormDB(): List<Channel>? {
                return channelDao.getChannelList()
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
}