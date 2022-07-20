package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.Channel
import com.bits.bee.bpmc.domain.model.Price
import com.bits.bee.bpmc.domain.repository.ChannelRepository
import com.bits.bee.bpmc.domain.repository.PriceRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestPriceUseCase @Inject constructor(private val channelRepository: PriceRepository) {

    operator fun invoke(): Flow<Resource<List<Price>>> {
        return channelRepository.getLatesPrice()
    }

}