package com.bits.bee.bpmc.domain.usecase.analisa_sesi

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBpByDateUseCase @Inject constructor(
   private val bpRepository: BpRepository
) {
    operator fun invoke(startDate: Long, endDate: Long): Flow<Resource<List<Bp>>>{
        return bpRepository.getBpByDate(startDate, endDate)
    }
}