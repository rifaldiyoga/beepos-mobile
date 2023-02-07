package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.model.BpAddr
import com.bits.bee.bpmc.domain.repository.BpAddrRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBpAddrByBpUseCase @Inject constructor(
    private val bpAddrRepository: BpAddrRepository
) {
    operator fun invoke(id: Int): Flow<BpAddr?> {
       return bpAddrRepository.getBpAddrByBp(id)
    }
}