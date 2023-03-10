package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBpByCodeUseCase @Inject constructor(
    private val bpRepository: BpRepository
) {
    operator fun invoke(code: String): Flow<Bp?>{
        return bpRepository.getBpByCode(code)
    }
}