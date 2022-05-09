package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.data.repository.ChannelRepository
import com.bits.bee.bpmc.domain.model.Channel
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestChannelUseCase @Inject constructor(private val channelRepository: ChannelRepository) {

    operator fun invoke(): Flow<Resource<List<Channel>>> {
        return channelRepository.getChannelList()
    }

}