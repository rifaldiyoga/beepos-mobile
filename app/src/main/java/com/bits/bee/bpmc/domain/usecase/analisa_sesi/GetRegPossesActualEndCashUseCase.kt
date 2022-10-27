package com.bits.bee.bpmc.domain.usecase.analisa_sesi

import com.bits.bee.bpmc.domain.model.Reg
import com.bits.bee.bpmc.domain.repository.RegRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRegPossesActualEndCashUseCase @Inject constructor(
    private val regRepository: RegRepository
) {
    operator fun invoke(): Flow<Reg>{
        return regRepository.getRegPossesActualEndcash()
    }
}