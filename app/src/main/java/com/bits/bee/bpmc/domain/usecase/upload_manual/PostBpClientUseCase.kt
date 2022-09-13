package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.data.data_source.remote.post.BpPost
import com.bits.bee.bpmc.data.data_source.remote.response.BpReturn
import com.bits.bee.bpmc.domain.repository.BpRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostBpClientUseCase @Inject constructor(
    private val bpRepository: BpRepository
) {
    operator fun invoke(bpPost: BpPost) = bpRepository.uploadBpClient(bpPost)
}