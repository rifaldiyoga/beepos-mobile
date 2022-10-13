package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.Reg
import com.bits.bee.bpmc.domain.repository.RegRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestRegUseCase @Inject constructor(private val regRepository: RegRepository) {

    operator fun invoke(): Flow<Resource<List<Reg>>> {
        return regRepository.getLatestRegList()
    }

}