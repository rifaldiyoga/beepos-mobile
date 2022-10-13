package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.Reg
import com.bits.bee.bpmc.domain.repository.RegRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 13/10/22
 */
class GetRegUseCase @Inject constructor(
    private val regRepository: RegRepository
) {

    operator fun invoke(code : String) : Flow<Reg?> {
        return regRepository.getRegByCode(code)
    }

}