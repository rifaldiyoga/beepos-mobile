package com.bits.bee.bpmc.domain.repository

import androidx.paging.PagingData
import com.bits.bee.bpmc.data.data_source.remote.post.PostAll
import com.bits.bee.bpmc.data.data_source.remote.response.PostAllReturn
import com.bits.bee.bpmc.domain.model.Sync
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface SyncRepository {
    fun getDataSync(): Flow<PagingData<Sync>>

    fun getSaleNotHaveBp(): Flow<Resource<List<Sync>>>

    fun getSyncHaventUploaded(): Flow<Resource<List<Sync>>>

    fun postSyncAll(postAll: PostAll): Flow<Resource<PostAllReturn>>

    fun getManualSyncLandscape(limit: Long, offset: Long): Flow<Resource<List<Sync>>>
}