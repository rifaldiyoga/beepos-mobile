package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.SaleCrcv
import com.bits.bee.bpmc.domain.repository.SaleCrcvRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSalecrcvBySaleUseCase @Inject constructor(
    private val saleCrcvRepository: SaleCrcvRepository
) {
    operator fun invoke(id: Int): Flow<List<SaleCrcv>>{
        return saleCrcvRepository.getSalecrcvBySale(id)
    }
}