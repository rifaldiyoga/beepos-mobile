package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.model.Regency
import com.bits.bee.bpmc.domain.repository.RegencyRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRegencyByCodeUseCase @Inject constructor(
    private val regencyRepository: RegencyRepository
) {
    operator fun invoke(regencyCode: String): Flow<Regency?>{
        return regencyRepository.getRegencyByCode(regencyCode)
    }
}