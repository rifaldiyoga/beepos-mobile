package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.Pmtd
import com.bits.bee.bpmc.domain.repository.PmtdRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestPmtdUseCase @Inject constructor(private val channelRepository: PmtdRepository) {

    operator fun invoke(): Flow<Resource<List<Pmtd>>> {
        return channelRepository.getLatestPmtdList()
    }

}