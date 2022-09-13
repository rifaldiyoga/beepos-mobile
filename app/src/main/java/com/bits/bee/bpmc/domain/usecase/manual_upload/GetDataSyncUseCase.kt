package com.bits.bee.bpmc.domain.usecase.manual_upload

import com.bits.bee.bpmc.domain.model.Sync
import com.bits.bee.bpmc.domain.repository.SyncRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDataSyncUseCase @Inject constructor(
    private val syncrepo: SyncRepository
) {
    operator fun invoke(limit: Long, offer: Long): Flow<Resource<List<Sync>>> {
        return syncrepo.getDataSync(limit, offer)
    }
}