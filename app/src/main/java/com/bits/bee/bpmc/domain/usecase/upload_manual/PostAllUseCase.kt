package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.data.data_source.remote.post.PostAll
import com.bits.bee.bpmc.domain.repository.SyncRepository
import javax.inject.Inject

class PostAllUseCase @Inject constructor(
    private val syncRepository: SyncRepository
) {
    operator fun invoke(postAll: PostAll) = syncRepository.postSyncAll(postAll)
}