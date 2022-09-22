package com.bits.bee.bpmc.domain.usecase.setting.help

import com.bits.bee.bpmc.domain.model.Sync
import com.bits.bee.bpmc.domain.repository.SyncRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHaventUploadedManualSyncUseCase @Inject constructor(
    private val syncRepository: SyncRepository
) {
     operator fun invoke(limit: Long, offset: Long): Flow<Resource<List<Sync>>>{
        return syncRepository.getManualSyncLandscape(limit, offset)
    }
}