package com.bits.bee.bpmc.domain.usecase.login.operator

import com.bits.bee.bpmc.domain.model.Cmp
import com.bits.bee.bpmc.domain.repository.CmpRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCmpUseCase @Inject constructor(
    private val cmpRepository: CmpRepository
) {
    operator fun invoke(): Flow<Cmp>{
        return cmpRepository.getCmp()
    }
}