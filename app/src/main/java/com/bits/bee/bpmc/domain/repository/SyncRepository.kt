package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.remote.post.PostAll
import com.bits.bee.bpmc.data.data_source.remote.response.PostAllReturn
import com.bits.bee.bpmc.domain.model.Sync
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface SyncRepository {
    fun getDataSync(limit: Long, offset: Long): Flow<Resource<List<Sync>>>

    fun getSaleNotHaveBp(): Flow<Resource<List<Sync>>>

    fun getSyncHaventUploaded(): Flow<Resource<List<Sync>>>

    fun postSyncAll(postAll: PostAll): Flow<Resource<PostAllReturn>>
}