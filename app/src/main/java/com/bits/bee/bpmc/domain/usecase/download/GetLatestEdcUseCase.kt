package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.Edc
import com.bits.bee.bpmc.domain.repository.EdcRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestEdcUseCase @Inject constructor(private val channelRepository: EdcRepository) {

    operator fun invoke(): Flow<Resource<List<Edc>>> {
        return channelRepository.getLatestEdc()
    }

}