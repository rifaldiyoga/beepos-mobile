package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.Unit
import com.bits.bee.bpmc.domain.repository.UnitRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestUnitUseCase @Inject constructor(private val channelRepository: UnitRepository) {

    operator fun invoke(): Flow<Resource<List<Unit>>> {
        return channelRepository.getLatestUnitList()
    }

}