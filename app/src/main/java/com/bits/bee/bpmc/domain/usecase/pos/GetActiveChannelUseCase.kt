package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.model.Channel
import com.bits.bee.bpmc.domain.repository.ChannelRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 21/04/22.
 */

class GetActiveChannelUseCase @Inject constructor(
    private val channelRepository: ChannelRepository
) {

    operator fun invoke(): Flow<List<Channel>> {
        return channelRepository.getActiveChannelList()
    }

}